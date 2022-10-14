package com.sy.rootingchecker;

import java.util.ArrayList;

public class DetectModule_4 extends ADetectModule {

    private DetectModuleProxy proxy;
    private int DetectIndex;

    public DetectModule_4(String _title, DetectModuleProxy _proxy, int _detectIndex) {
        title = _title;
        proxy = _proxy;
        DetectIndex = _detectIndex;
    }

    @Override
    public ArrayList<DetectResult> runDetect() {
        ArrayList<DetectResult> result = new ArrayList<DetectResult>();
        result.add(new DetectResult(title, proxy.runDetect(DetectIndex)));
        return result;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
