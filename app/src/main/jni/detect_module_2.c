//
// Created by sy84l on 2022-10-11.
//
#include "detect_module_2.h"
#include "library_abstract_layer.h"

#include <stdio.h>
#include <string.h>

#define BUFFER_SIZE    1024

//4. Detect Module 4: Check which su
static int run_detect()
{
    FILE* f = sal_popen()("which su", "r");

    char buff[BUFFER_SIZE] = {0, };

    if (f == NULL) {
        return NOT_DETECTED;
    }

    while (fgets(buff, BUFFER_SIZE, f))

    pclose(f);
    int size = strlen(buff);

    if (size > 0)
        return DETECTED;
    else
        return NOT_DETECTED;
}

detect_module *setup_detect_module_2(void)
{
    static detect_module this;
    this.run_detect = run_detect;

    return &this;
}