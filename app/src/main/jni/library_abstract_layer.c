//
// Created by sy84l on 2022-10-16.
//
#include <unistd.h>
#include <stdio.h>
#include <string.h>

#define RELEASE_MODE    0
#define TEST_MODE       1
#define MAX_STRING      128

// TEST enable/disable
static int MOCK_INTERFACE = RELEASE_MODE;

void enable_test() {
    MOCK_INTERFACE = TEST_MODE;
}

void disable_test() {
    MOCK_INTERFACE = RELEASE_MODE;
}

// For mock execl()
static int execl_return = 1;

void set_execl_return_value(int value) {
    execl_return = value;
}

int execl_mock(const char* __path, const char* __arg0, ...) {
    return execl_return;
}

int (*sal_execl())(const char* __path, const char* __arg0, ...) {
    if (MOCK_INTERFACE == RELEASE_MODE) {
        return execl;
    }
    else {
        return execl_mock;
    }
}

// For mock popen()
static char popen_command[MAX_STRING] = {0, };

void set_popen_command_value(const char* value) {
    memset(popen_command, 0x00, MAX_STRING);
    memcpy(popen_command, value, strlen(value));
}

FILE* popen_mock(const char* __command, const char* __mode) {
    return popen(popen_command, "r");
}

FILE* (*sal_popen())(const char* __command, const char* __mode) {
    if (MOCK_INTERFACE == RELEASE_MODE) {
        return popen;
    }
    else {
        return popen_mock;
    }
}

// For mock access()
static int access_return = 0;

void set_access_return_value(int value) {
    access_return = value;
}

int access_mock(const char* __path, int __mode) {
    return access_return;
}

int (*sal_access())(const char* __path, int __mode) {
    if (MOCK_INTERFACE == RELEASE_MODE) {
        return access;
    }
    else {
        return access_mock;
    }
}

// For mock __system_property_get_mock()
static int SYSTEM_PROPERTY_ID_ANDROID_OS_BUILD_TAGS   = 1;
static int SYSTEM_PROPERTY_ID_RO_DEBUGGABLE           = 2;
static int SYSTEM_PROPERTY_ID_SERVICE_ADB_ROOT        = 3;
static int SYSTEM_PROPERTY_ID_RO_SECURE               = 4;
static int SYSTEM_PROPERTY_ID_SYS_INITD               = 5;
static int SYSTEM_PROPERTY_ID_RO_BUILD_SELINUX        = 6;

static char system_properties[10][MAX_STRING] = {0, };

void set_property_value(const int id, const char* value) {
    memset(system_properties[id], 0x00, MAX_STRING);
    memcpy(system_properties[id], value, strlen(value));
}

int __system_property_get_mock(const char* __name, char* __value) {
    if (strncmp(__name, "ro.build.tags", strlen("ro.build.tags")) == 0) {
        memcpy(__value, system_properties[SYSTEM_PROPERTY_ID_ANDROID_OS_BUILD_TAGS], strlen(system_properties[SYSTEM_PROPERTY_ID_ANDROID_OS_BUILD_TAGS]));
        return strlen(system_properties[SYSTEM_PROPERTY_ID_ANDROID_OS_BUILD_TAGS]);
    }
    else if (strncmp(__name, "ro.debuggable", strlen("ro.debuggable")) == 0) {
        memcpy(__value, system_properties[SYSTEM_PROPERTY_ID_RO_DEBUGGABLE], strlen(system_properties[SYSTEM_PROPERTY_ID_RO_DEBUGGABLE]));
        return strlen(system_properties[SYSTEM_PROPERTY_ID_RO_DEBUGGABLE]);
    }
    else if (strncmp(__name, "service.adb.root", strlen("service.adb.root")) == 0) {
        memcpy(__value, system_properties[SYSTEM_PROPERTY_ID_SERVICE_ADB_ROOT], strlen(system_properties[SYSTEM_PROPERTY_ID_SERVICE_ADB_ROOT]));
        return strlen(system_properties[SYSTEM_PROPERTY_ID_SERVICE_ADB_ROOT]);
    }
    else if (strncmp(__name, "ro.secure", strlen("ro.secure")) == 0) {
        memcpy(__value, system_properties[SYSTEM_PROPERTY_ID_RO_SECURE], strlen(system_properties[SYSTEM_PROPERTY_ID_RO_SECURE]));
        return strlen(system_properties[SYSTEM_PROPERTY_ID_RO_SECURE]);
    }
    else if (strncmp(__name, "sys.initd", strlen("sys.initd")) == 0) {
        memcpy(__value, system_properties[SYSTEM_PROPERTY_ID_SYS_INITD], strlen(system_properties[SYSTEM_PROPERTY_ID_SYS_INITD]));
        return strlen(system_properties[SYSTEM_PROPERTY_ID_SYS_INITD]);
    }
    else if (strncmp(__name, "ro.build.selinux", strlen("ro.build.selinux")) == 0) {
        memcpy(__value, system_properties[SYSTEM_PROPERTY_ID_RO_BUILD_SELINUX], strlen(system_properties[SYSTEM_PROPERTY_ID_RO_BUILD_SELINUX]));
        return strlen(system_properties[SYSTEM_PROPERTY_ID_RO_BUILD_SELINUX]);
    }
    else {
        return 0;
    }
}

int (*sal__system_property_get())(const char* __name, char* __value) {
    if (MOCK_INTERFACE == RELEASE_MODE) {
        return __system_property_get;
    }
    else {
        return __system_property_get_mock;
    }
}