//
// Created by sy84l on 2022-10-12.
//
#include "detect_module_3.h"
#include "library_abstract_layer.h"

#include <unistd.h>

const char * const SU_PATHS[] = {
        "/data/local/su",
        "/data/local/bin/su",
        "/data/local/xbin/su",
        "/sbin/su",
        "/system/bin/su",
        "/system/bin/.ext/su",
        "/system/bin/failsafe/su",
        "/system/sd/xbin/su",
        "/su/xbin/su",
        "/su/bin/su",
        "/magisk/.core/bin/su",
        "/system/usr/we-need-root/su",
        "/system/xbin/su",
        0
};

static int run_detect()
{
    for (int i = 0; SU_PATHS[i]; i++) {
        if (0 == SU_PATHS[i])
            break;
        int result = sal_access()(SU_PATHS[i], F_OK);
        //int result = access(SU_PATHS[i], F_OK);
        if (result == 0) {
            return DETECTED;
        }
    }
    return NOT_DETECTED;
}

detect_module *setup_detect_module_3(void)
{
    static detect_module this;
    this.run_detect = run_detect;

    return &this;
}