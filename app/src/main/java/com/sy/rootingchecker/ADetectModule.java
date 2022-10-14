package com.sy.rootingchecker;

import java.util.ArrayList;

public abstract class ADetectModule {

    final static int DETECT        = 1;
    final static int NOT_DETECT    = 0;

    String title;
    public abstract ArrayList<DetectResult> runDetect();
    public abstract String getTitle();
}
