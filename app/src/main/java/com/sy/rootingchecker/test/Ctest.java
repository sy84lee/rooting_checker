package com.sy.rootingchecker.test;

public class Ctest {

    final static public int SYSTEM_PROPERTY_ID_ANDROID_OS_BUILD_TAGS   = 1;
    final static public int SYSTEM_PROPERTY_ID_RO_DEBUGGABLE           = 2;
    final static public int SYSTEM_PROPERTY_ID_SERVICE_ADB_ROOT        = 3;
    final static public int SYSTEM_PROPERTY_ID_RO_SECURE               = 4;
    final static public int SYSTEM_PROPERTY_ID_SYS_INITD               = 5;
    final static public int SYSTEM_PROPERTY_ID_RO_BUILD_SELINUX        = 6;

    public native void enableTest();
    public native void disableTest();
    public native void setExeclReturnValue(int value);
    public native void setPopenCommandValue(String value);
    public native void setAccessReturnValue(int value);
    public native void setSystemPropertyValue(int id, String value);
}
