//
// Created by sy84l on 2022-10-15.
//

#include "detect_module_6.h"

#include <sys/system_properties.h>
#include <string.h>

static char *ANDROID_OS_BUILD_TAGS = "ro.build.tags";

static int run_detect()
{
    const char *TEST_KEYS_VALUE = "release-keys";
    char value[100] = {0,};
    int length = __system_property_get(ANDROID_OS_BUILD_TAGS, value);

    if (length > 0) {
        if (strcmp(value, TEST_KEYS_VALUE) != 0) {
            return DETECTED;
        }
    }
    else {
        return NOT_DETECTED;
    }
    return NOT_DETECTED;
}

detect_module *setup_detect_module_6(void)
{
    static detect_module this;
    this.run_detect = run_detect;

    return &this;
}