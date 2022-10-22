package com.sy.rootingchecker;

import java.util.ArrayList;

public class DetectModule_3_Item extends AbstractDetectModule {

    private DetectModuleProxy proxy;
    private int detectIndex;

    public DetectModule_3_Item(String _title, DetectModuleProxy _proxy, int _detectIndex) {
        title = _title;
        proxy = _proxy;
        detectIndex = _detectIndex;
    }

    @Override
    public ArrayList<DetectResult> runDetect() {
        ArrayList<DetectResult> result = new ArrayList<DetectResult>();
        try {
            result.add(new DetectResult(title, proxy.runDetect(detectIndex)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
