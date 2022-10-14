package com.sy.rootingchecker;

import android.util.Log;

import java.util.ArrayList;

public class DetectModule_3 extends ADetectModule {

    ArrayList<ADetectModule> modules = new ArrayList<ADetectModule>();

    public DetectModule_3(String _title) {
        title = _title;
        DetectModuleProxy proxy = new DetectModuleProxy();
        proxy.initModules();
        int count = proxy.getDetectModuleCount();
        for (int i = 0; i < count; i++) {
            modules.add(new DetectModule_4(proxy.getDetectTitle(i), proxy, i));
        }
    }

    @Override
    public ArrayList<DetectResult> runDetect() {
        ArrayList<DetectResult> result = new ArrayList<DetectResult>();

        for (ADetectModule module : modules) {
            result.add(module.runDetect().get(0));
        }
        return result;
    }

    @Override
    public String getTitle() {
        return null;
    }
}
