package com.sy.rootingchecker;

import java.util.ArrayList;

//2. Detect Module 2: Check Build.TAGS: test-keys
public class DetectModule_2 extends AbstractDetectModule {

    public DetectModule_2(String _title) {
        title = _title;
    }

    @Override
    public ArrayList<DetectResult> runDetect() {
        ArrayList<DetectResult> result = new ArrayList<DetectResult>();

        String buildTags = android.os.Build.TAGS;
        if(buildTags != null && buildTags.contains("test-keys")) {
            result.add(new DetectResult(title, DETECT));
        }
        else {
            result.add(new DetectResult(title, NOT_DETECT));
        }
        return result;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
