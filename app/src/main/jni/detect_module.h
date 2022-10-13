//
// Created by sy84l on 2022-10-11.
//

#ifndef ROOTINGCHECKER_DETECT_MODULE_H
#define ROOTINGCHECKER_DETECT_MODULE_H

#define DETECTED        1
#define NOT_DETECTED    0

typedef struct detect_module {
    int (*run_detect)(void);
} detect_module;

#endif //ROOTINGCHECKER_DETECT_MODULE_H
