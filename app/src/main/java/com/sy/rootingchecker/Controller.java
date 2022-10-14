package com.sy.rootingchecker;

import android.util.Log;

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

    public ArrayList<DetectResult> startDetect() {
        ArrayList<DetectResult> result = new ArrayList<DetectResult>();
        for (ADetectModule module : modules) {
                result.addAll(module.runDetect());
        }
        return result;
    }
}
