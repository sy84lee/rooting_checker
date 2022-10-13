package com.sy.rootingchecker;

import java.util.ArrayList;

public class Controller {

    ArrayList<ADetectModule> modules = new ArrayList<ADetectModule>();

    public Controller() {
        initModules();
    }

    private void initModules() {
        modules.add(new DetectModule_1("Check SuperuserAPK"));
        modules.add(new DetectModule_2("Check Build.prop: test-key"));
        modules.add(new DetectModule_3("Check Native Level"));
    }

    public int startDetect() {
        for (ADetectModule module : modules) {
            if (module.runDetect() == module.DETECT) {
                return ADetectModule.DETECT;
            }
        }
        return ADetectModule.NOT_DETECT;
    }
}
