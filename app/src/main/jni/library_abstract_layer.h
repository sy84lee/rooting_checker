//
// Created by sy84l on 2022-10-16.
//

#ifndef ROOTINGCHECKER_LIBRARY_ABSTRACT_LAYER_H
#define ROOTINGCHECKER_LIBRARY_ABSTRACT_LAYER_H

#include <stdio.h>

void enable_test();
void disable_test();

void set_execl_return_value(int value);
int (*sal_execl())(const char* __path, const char* __arg0, ...);

void set_popen_command_value(const char* value);
FILE* (*sal_popen())(const char* __command, const char* __mode);

void set_access_return_value(int value);
int (*sal_access())(const char* __path, int __mode);

void set_property_value(int id, const char* value);
int (*sal__system_property_get())(const char* __name, char* __value);

#endif //ROOTINGCHECKER_LIBRARY_ABSTRACT_LAYER_H
