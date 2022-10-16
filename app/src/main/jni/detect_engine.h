/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_sy_rootingchecker_DetectModuleProxy */

#ifndef _Included_com_sy_rootingchecker_DetectModuleProxy
#define _Included_com_sy_rootingchecker_DetectModuleProxy
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_sy_rootingchecker_DetectModuleProxy
 * Method:    initModules
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_sy_rootingchecker_DetectModuleProxy_initModules
  (JNIEnv *, jobject);

/*
 * Class:     com_sy_rootingchecker_DetectModuleProxy
 * Method:    runDetect
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_sy_rootingchecker_DetectModuleProxy_runDetect
  (JNIEnv *, jobject, jint);

/*
 * Class:     com_sy_rootingchecker_DetectModuleProxy
 * Method:    getDetectModuleCount
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_sy_rootingchecker_DetectModuleProxy_getDetectModuleCount
  (JNIEnv *, jobject);

/*
 * Class:     com_sy_rootingchecker_DetectModuleProxy
 * Method:    getDetectTitle
 * Signature: (I)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_sy_rootingchecker_DetectModuleProxy_getDetectTitle
  (JNIEnv *, jobject, jint);

/*
 * Class:     com_sy_rootingchecker_DetectModuleProxy
 * Method:    enableTest
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_sy_rootingchecker_DetectModuleProxy_enableTest
  (JNIEnv *, jobject);

/*
 * Class:     com_sy_rootingchecker_DetectModuleProxy
 * Method:    disableTest
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_sy_rootingchecker_DetectModuleProxy_disableTest
  (JNIEnv *, jobject);

/*
 * Class:     com_sy_rootingchecker_DetectModuleProxy
 * Method:    setExeclReturnValue
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_sy_rootingchecker_DetectModuleProxy_setExeclReturnValue
  (JNIEnv *, jobject, jint);

#ifdef __cplusplus
}
#endif
#endif
