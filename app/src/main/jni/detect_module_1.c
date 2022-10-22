//
// Created by sy84l on 2022-10-11.
//

#include "detect_module_1.h"
#include "library_abstract_layer.h"

#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <paths.h>
#include <signal.h>

//3. Detect Module 3: Check execute su
static int run_detect()
{
    int result = NOT_DETECTED;
    int status = 0;

    pid_t pid = -1;
    pid = fork();

    if (pid == 0) {

        int execute = sal_execl()("/system/bin/su", "su", NULL);

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