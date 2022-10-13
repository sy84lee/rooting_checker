//
// Created by sy84l on 2022-10-13.
//

#include "detect_module_4.h"

#include <unistd.h>

const char * const XPOSE_FILES[] = {
        "/system/lib/libxposed_art.so",
        "/system/lib64/libxposed_art.so",
        "/system/xposed.prop",
        "/cache/recovery/xposed.zip",
        "/system/framework/XposedBridge.jar",
        "/system/bin/app_process64_xposed",
        "/system/bin/app_process32_xposed",
        "/magisk/xposed/system/lib/libsigchain.so",
        "/magisk/xposed/system/lib/libart.so",
        "/magisk/xposed/system/lib/libart-disassembler.so",
        "/magisk/xposed/system/lib/libart-compiler.so",
        "/system/bin/app_process32_orig",
        "/system/bin/app_process64_orig",
        "/system/lib/libmemtrack_real.so",
        "/system/lib64/libmemtrack_real.so",
        "/system/lib/libriru_edxp.so",
        "/system/lib64/libriru_edxp.so",
        "/system/lib/libwhale.edxp.so",
        "/system/lib64/libwhale.edxp.so",
        "/system/framework/edxp.jar",
        0
};

static int run_detect()
{
    for (int i = 0; XPOSE_FILES[i]; i++) {
        if (0 == XPOSE_FILES[i])
            break;
        int result = access(XPOSE_FILES[i], F_OK);
        if (result == 0) {
            return DETECTED;
        }
    }
    return NOT_DETECTED;
}

detect_module *setup_detect_module_4(void)
{
    static detect_module this;
    this.run_detect = run_detect;

    return &this;
}