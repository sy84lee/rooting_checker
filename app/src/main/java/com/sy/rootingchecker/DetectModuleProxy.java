package com.sy.rootingchecker;

public class DetectModuleProxy {
    static {
        System.loadLibrary("detectEngine");
    }

    public native void initModules();
    public native int runDetect(int index);
    public native int getDetectModuleCount();
    public native String getDetectTitle(int index);
}
