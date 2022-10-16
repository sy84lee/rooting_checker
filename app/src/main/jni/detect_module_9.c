//
// Created by sy84l on 2022-10-15.
//

#include "detect_module_9.h"
#include "library_abstract_layer.h"

#include <unistd.h>

static int run_detect()
{
    int result = sal_access()("/data/magisk/resetprop", F_OK);
    //int result = access("/data/magisk/resetprop", F_OK);
    if (result == 0) {
        return DETECTED;
    }
    return NOT_DETECTED;
}

detect_module *setup_detect_module_9(void)
{
    static detect_module this;
    this.run_detect = run_detect;

    return &this;
}