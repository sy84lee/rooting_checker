package com.sy.rootingchecker;

import java.io.File;
import java.util.ArrayList;

//1. Detect Module 1: Check exist Superuser.apk
public class DetectModule_1 extends AbstractDetectModule {

    public DetectModule_1(String _title) {
        title = _title;
    }

    @Override
    public ArrayList<DetectResult> runDetect() {
        ArrayList<DetectResult> result = new ArrayList<DetectResult>();

        if (new File("/system/app/Superuser.apk").exists()) {
            result.add(new DetectResult(title, DETECT));
        }
        else {
            result.add(new DetectResult(title, NOT_DETECT));
        } return result;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
