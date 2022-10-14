//
// Created by sy84l on 2022-10-15.
//


#include <stdio.h>
#include <mntent.h>
#include <string.h>
#include "detect_module_7.h"

const char * const MG_READ_ONLY_PATH[] = {
        "/system",
        "/system/bin",
        "/system/sbin",
        "/system/xbin",
        "/vendor/bin",
        "/sbin",
        "/etc",
        0
};

struct mntent *getMntent(FILE *fp, struct mntent *e, char *buf, int buf_len) {

    while (fgets(buf, buf_len, fp) != NULL) {
        // Entries look like "/dev/block/vda /system ext4 ro,seclabel,relatime,data=ordered 0 0".
        // That is: mnt_fsname mnt_dir mnt_type mnt_opts mnt_freq mnt_passno.
        int fsname0, fsname1, dir0, dir1, type0, type1, opts0, opts1;
        if (sscanf(buf, " %n%*s%n %n%*s%n %n%*s%n %n%*s%n %d %d",
                   &fsname0, &fsname1, &dir0, &dir1, &type0, &type1, &opts0, &opts1, &e->mnt_freq, &e->mnt_passno) == 2) {
            e->mnt_fsname = &buf[fsname0];
            buf[fsname1] = '\0';
            e->mnt_dir = &buf[dir0];
            buf[dir1] = '\0';
            e->mnt_type = &buf[type0];
            buf[type1] = '\0';
            e->mnt_opts = &buf[opts0];
            buf[opts1] = '\0';
            return e;
        }
    }
    return NULL;
}

int isPresentMntOpt(const struct mntent *pMnt, const char *pOpt) {
    char *token = pMnt->mnt_opts;
    const char *end = pMnt->mnt_opts + strlen(pMnt->mnt_opts);
    const size_t optLen = strlen(pOpt);
    while (token != NULL) {
        const char *tokenEnd = token + optLen;
        if (tokenEnd > end) break;
        if (memcmp(token, pOpt, optLen) == 0 &&
            (*tokenEnd == '\0' || *tokenEnd == ',' || *tokenEnd == '=')) {
            return DETECTED;
        }
        token = strchr(token, ',');
        if (token != NULL) {
            token++;
        }
    }
    return NOT_DETECTED;
}

static int run_detect()
{
    int result = NOT_DETECTED;
    FILE *file = fopen("/proc/mounts", "r");
    char mntent_strings[BUFSIZ];

    struct mntent ent = {0};
    while (NULL != getMntent(file, &ent, mntent_strings, sizeof(mntent_strings))) {
        for (size_t i = 0; MG_READ_ONLY_PATH[i]; i++) {
            if (strcmp((&ent)->mnt_dir, MG_READ_ONLY_PATH[i]) == 0 &&
                isPresentMntOpt(&ent, "rw")) {
                result = DETECTED;
                break;
            }
        }
        memset(&ent, 0, sizeof(ent));
    }
    fclose(file);

    return result;
}

detect_module *setup_detect_module_7(void)
{
    static detect_module this;
    this.run_detect = run_detect;

    return &this;
}