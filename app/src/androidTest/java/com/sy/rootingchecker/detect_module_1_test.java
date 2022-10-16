package com.sy.rootingchecker;

import static com.sy.rootingchecker.AbstractDetectModule.DETECT;
import static com.sy.rootingchecker.AbstractDetectModule.NOT_DETECT;
import static org.junit.Assert.assertEquals;
import com.sy.rootingchecker.test.Ctest;
import org.junit.Test;

public class detect_module_1_test {
    static {
        System.loadLibrary("detectEngine");
    }

    @Test
    public void run_detect_Not_Execute_su_NOT_DETECT() {
        Ctest ctest = new Ctest();
        ctest.enableTest();
        ctest.setExeclReturnValue(1);

        DetectModuleProxy proxy = new DetectModuleProxy();
        proxy.initModules();
        assertEquals(NOT_DETECT, proxy.runDetect(0));

        ctest.disableTest();
    }

    @Test
    public void run_detect_Execute_su_DETECT() {
        Ctest ctest = new Ctest();
        ctest.enableTest();
        ctest.setExeclReturnValue(0);

        DetectModuleProxy proxy = new DetectModuleProxy();
        proxy.initModules();
        assertEquals(DETECT, proxy.runDetect(0));

        ctest.disableTest();
    }
}
