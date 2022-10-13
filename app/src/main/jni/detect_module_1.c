//
// Created by sy84l on 2022-10-11.
//

#include "detect_module_1.h"

#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <paths.h>
#include <signal.h>

static int run_detect()
{
    int result = 0;
    int status = 0;

    pid_t pid = -1;
    pid = fork();

    if (pid == 0) {
        int execute = execl("/system/bin/su", "su", NULL);

        if(execute != 0) {  //Not Execute
            exit(1);
        }
        else {
            exit(0);  // Execute
        }
    }
    else if (pid > 0) {
        wait(&status);
    }

    if(status == 0) {
        result = DETECTED;
    }
    return result;
}

detect_module *setup_detect_module_1(void)
{
    static detect_module this;
    this.run_detect = run_detect;

    return &this;
}