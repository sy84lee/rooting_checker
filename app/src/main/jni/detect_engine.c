//
// Created by sy84l on 2022-10-11.
//

#include "detect_engine.h"
#include "detect_module_1.h"
#include "detect_module_2.h"
#include "detect_module_3.h"
#include "detect_module_4.h"
#include <stdint.h>

typedef struct module_info {
    detect_module* module;
    char* module_name;
} module_info;

static uint32_t count_module = 0;
static module_info modules[100];

void add_module(detect_module* module, char* name) {
    modules[count_module].module = module;
    modules[count_module].module_name = name;
    count_module++;
}

void init_detect_modules() {
    //add_module(setup_detect_module_1(), "Check execute su");
    //add_module(setup_detect_module_2(), "Check which su");
    //add_module(setup_detect_module_3(), "Check su files");
    add_module(setup_detect_module_4(), "Check xpose files");
}

uint32_t getModuleCount() {
    return count_module;
}

JNIEXPORT jint JNICALL Java_com_sy_rootingchecker_Controller_runDetect
        (JNIEnv *env, jobject this) {
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