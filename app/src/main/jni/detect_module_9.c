//
// Created by sy84l on 2022-10-16.
//

#include "detect_module_9.h"
#include "library_abstract_layer.h"

#include <unistd.h>

//11. Detect Module 11: Check busybox files
const char * const BUSYBOX_PATHS[] = {
        "/data/local/busybox",
        "/data/local/bin/busybox",
        "/data/local/xbin/busybox",
        "/sbin/busybox",
        "/system/bin/busybox",
        "/system/bin/.ext/busybox",
        "/system/bin/failsafe/busybox",
        "/system/sd/xbin/busybox",
        "/su/xbin/busybox",
        "/su/bin/busybox",
        "/magisk/.core/bin/busybox",
        "/system/usr/we-need-root/busybox",
        "/system/xbin/busybox",
        0
};

static int run_detect()
{
    for (int i = 0; BUSYBOX_PATHS[i]; i++) {
        if (0 == BUSYBOX_PATHS[i])
            break;
        int result = sal_access()(BUSYBOX_PATHS[i], F_OK);
        //int result = access(BUSYBOX_PATHS[i], F_OK);
        if (result == 0) {
            return DETECTED;
        }
    }
    return NOT_DETECTED;
}

detect_module *setup_detect_module_9(void)
{
    static detect_module this;
    this.run_detect = run_detect;

    return &this;
}