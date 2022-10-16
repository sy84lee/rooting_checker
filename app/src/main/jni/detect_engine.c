//
// Created by sy84l on 2022-10-11.
//

#include "detect_engine.h"
#include "detect_module_1.h"
#include "detect_module_2.h"
#include "detect_module_3.h"
#include "detect_module_4.h"
#include "detect_module_5.h"
#include "detect_module_6.h"
#include "detect_module_7.h"
#include "detect_module_8.h"
#include "detect_module_9.h"
#include "detect_module_10.h"
#include "library_abstract_layer.h"
#include <stdint.h>
#include <string.h>

typedef struct module_info {
    detect_module* module;
    char* module_name;
} module_info;

static uint32_t count_module = 0;
static module_info modules[100];

static void add_module(detect_module* module, char* name) {
    modules[count_module].module = module;
    modules[count_module].module_name = name;
    count_module++;
}

static void init_detect_modules() {
    memset(modules, 0x00, sizeof(module_info)*100);
    count_module = 0;
    add_module(setup_detect_module_1(), "Check execute su");
    add_module(setup_detect_module_2(), "Check which su");
    add_module(setup_detect_module_3(), "Check su files");
    add_module(setup_detect_module_4(), "Check xpose files");
    add_module(setup_detect_module_5(), "Check Build.prop: dev-keys");
    add_module(setup_detect_module_6(), "Check Build.prop: release-keys");
    //add_module(setup_detect_module_7(), "This is Reference Module for checking mount");
    add_module(setup_detect_module_8(), "Check Bad Properties values");
    add_module(setup_detect_module_9(), "Check Magisk resetprop");
    add_module(setup_detect_module_10(), "Check busybox files");
}

static uint32_t getModuleCount() {
    return count_module;
}

JNIEXPORT void JNICALL Java_com_sy_rootingchecker_DetectModuleProxy_initModules
        (JNIEnv *env, jobject this) {
    init_detect_modules();
}

JNIEXPORT jint JNICALL Java_com_sy_rootingchecker_DetectModuleProxy_runDetect
        (JNIEnv *env, jobject this, jint index) {
    return modules[index].module->run_detect();
}

JNIEXPORT jint JNICALL Java_com_sy_rootingchecker_DetectModuleProxy_getDetectModuleCount
        (JNIEnv *env, jobject this) {
    return count_module;
}

JNIEXPORT jstring JNICALL Java_com_sy_rootingchecker_DetectModuleProxy_getDetectTitle
        (JNIEnv *env, jobject this, jint index) {
    return (*env)->NewStringUTF(env, modules[index].module_name);
}



JNIEXPORT void JNICALL Java_com_sy_rootingchecker_DetectModuleProxy_enableTest
        (JNIEnv *env, jobject thiz) {
    enable_test();
}

JNIEXPORT void JNICALL Java_com_sy_rootingchecker_DetectModuleProxy_disableTest
        (JNIEnv *env, jobject thiz) {
    disable_test();
}

JNIEXPORT void JNICALL Java_com_sy_rootingchecker_DetectModuleProxy_setExeclReturnValue
        (JNIEnv *env, jobject thiz, jint value) {
    set_execl_return_value(value);
}