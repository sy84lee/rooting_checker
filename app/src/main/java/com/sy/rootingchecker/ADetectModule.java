package com.sy.rootingchecker;

public abstract class ADetectModule {

    final static int DETECT        = 1;
    final static int NOT_DETECT    = 0;

    String title;
    public abstract int runDetect();
    public abstract String getTitle();
}
