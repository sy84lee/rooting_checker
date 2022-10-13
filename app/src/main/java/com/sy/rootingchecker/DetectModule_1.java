package com.sy.rootingchecker;

import java.io.File;

public class DetectModule_1 extends ADetectModule {

    public DetectModule_1(String _title) {
        title = _title;
    }

    @Override
    public int runDetect() {
        if (new File("/system/app/Superuser.apk").exists()) {
            return DETECT;
        }
        else {
            return NOT_DETECT;
        }
    }

    @Override
    public String getTitle() {
        return title;
    }
}
