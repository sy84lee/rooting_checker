package com.sy.rootingchecker;

public class DetectModule_2 extends ADetectModule {

    public DetectModule_2(String _title) {
        title = _title;
    }

    @Override
    public int runDetect() {
        String buildTags = android.os.Build.TAGS;
        if (buildTags != null && buildTags.contains("test-keys")) {
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
