package com.sy.rootingchecker;

import com.sy.rootingchecker.test.Ctest;

import java.util.ArrayList;

public class Controller {

    ArrayList<AbstractDetectModule> modules = new ArrayList<AbstractDetectModule>();

    public Controller() {
        initModules();
    }

    private void initModules() {
        modules.add(new DetectModule_1("Check SuperuserAPK"));
        modules.add(new DetectModule_2("Check Build.prop: test-key"));
        modules.add(new DetectModule_3("Check Native Level"));
        modules.add(new DetectModule_4("Check Mount Status"));
    }

    public ArrayList<DetectResult> startDetect() {
        ArrayList<DetectResult> result = new ArrayList<DetectResult>();
        for (AbstractDetectModule module : modules) {
                result.addAll(module.runDetect());
        }
        return result;
    }
}
