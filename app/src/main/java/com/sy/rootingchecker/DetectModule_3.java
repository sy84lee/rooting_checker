package com.sy.rootingchecker;

import java.util.ArrayList;

public class DetectModule_3 extends AbstractDetectModule {

    ArrayList<AbstractDetectModule> modules = new ArrayList<AbstractDetectModule>();

    public DetectModule_3(String _title) {
        title = _title;
        DetectModuleProxy proxy = new DetectModuleProxy();
        proxy.initModules();
        int count = proxy.getDetectModuleCount();
        for (int i = 0; i < count; i++) {
            modules.add(new DetectModule_3_Item(proxy.getDetectTitle(i), proxy, i));
        }
    }

    @Override
    public ArrayList<DetectResult> runDetect() {
        ArrayList<DetectResult> result = new ArrayList<DetectResult>();

        for (AbstractDetectModule module : modules) {
            result.add(module.runDetect().get(0));
        }
        return result;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
