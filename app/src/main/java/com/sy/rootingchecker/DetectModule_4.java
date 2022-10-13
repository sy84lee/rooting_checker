package com.sy.rootingchecker;

public class DetectModule_4 extends ADetectModule {

    private DetectModuleProxy proxy;
    private int DetectIndex;

    public DetectModule_4(String _title, DetectModuleProxy _proxy, int _detectIndex) {
        title = _title;
        proxy = _proxy;
        DetectIndex = _detectIndex;
    }

    @Override
    public int runDetect() {
        return proxy.runDetect(DetectIndex);
    }

    @Override
    public String getTitle() {
        return title;
    }
}
