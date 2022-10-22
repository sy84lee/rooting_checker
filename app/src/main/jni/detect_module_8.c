//
// Created by sy84l on 2022-10-15.
//

#include "detect_module_8.h"
#include "library_abstract_layer.h"

#include <unistd.h>

//10. Detect Module 10: Check magisk file
static int run_detect()
{
    int result = sal_access()("/data/magisk/resetprop", F_OK);
    if (result == 0) {
        return DETECTED;
    }
    return NOT_DETECTED;
}

detect_module *setup_detect_module_8(void)
{
    static detect_module this;
    this.run_detect = run_detect;

    return &this;
}