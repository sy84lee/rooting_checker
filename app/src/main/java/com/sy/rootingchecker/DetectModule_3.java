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
            //Log.i("ssss", proxy.getDetectTitle(i));
        }
    }

    @Override
    public int runDetect() {
        for (ADetectModule module : modules) {
            if (module.runDetect() == DETECT) {
                return DETECT;
            }
        }
        return NOT_DETECT;
    }

    @Override
    public String getTitle() {
        return null;
    }
}
