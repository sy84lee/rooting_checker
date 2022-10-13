//
// Created by sy84l on 2022-10-11.
//
#include "detect_module_2.h"

#include <stdio.h>
#include <string.h>

#define BUFFER_SIZE    1024

static int run_detect()
{
    FILE* f = popen("which su", "r");

    char buff[BUFFER_SIZE];

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