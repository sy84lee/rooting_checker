//
// Created by sy84l on 2022-10-16.
//

#include "com_sy_rootingchecker_test_Ctest.h"
#include "library_abstract_layer.h"

JNIEXPORT void JNICALL Java_com_sy_rootingchecker_test_Ctest_enableTest
        (JNIEnv *env, jobject thiz) {
    enable_test();
}

JNIEXPORT void JNICALL Java_com_sy_rootingchecker_test_Ctest_disableTest
(JNIEnv *env, jobject thiz) {
    disable_test();
}

JNIEXPORT void JNICALL Java_com_sy_rootingchecker_test_Ctest_setExeclReturnValue
(JNIEnv *env, jobject thiz, jint value) {
    set_execl_return_value(value);
}

JNIEXPORT void JNICALL Java_com_sy_rootingchecker_test_Ctest_setPopenCommandValue
(JNIEnv *env, jobject thiz, jstring value) {
    set_popen_command_value(((*env)->GetStringUTFChars(env, value, 0)));
}

JNIEXPORT void JNICALL Java_com_sy_rootingchecker_test_Ctest_setAccessReturnValue
(JNIEnv *env, jobject thiz, jint value) {
    set_access_return_value(value);
}

JNIEXPORT void JNICALL Java_com_sy_rootingchecker_test_Ctest_setSystemPropertyValue
(JNIEnv *env, jobject thiz, jint id, jstring value) {
    set_property_value(id, ((*env)->GetStringUTFChars(env, value, 0)));
}