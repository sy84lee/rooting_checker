package com.sy.rootingchecker;

import static com.sy.rootingchecker.AbstractDetectModule.DETECT;
import static com.sy.rootingchecker.AbstractDetectModule.NOT_DETECT;
import static org.junit.Assert.assertEquals;
import com.sy.rootingchecker.test.Ctest;
import org.junit.Test;
import java.io.IOException;

public class detect_module_2_test {
    static {
        System.loadLibrary("detectEngine");
    }

    @Test
    public void run_detect_Exist_which_su_DETECT() throws IOException {
        Ctest ctest = new Ctest();
        ctest.enableTest();
        ctest.setPopenCommandValue("which ls");

        DetectModuleProxy proxy = new DetectModuleProxy();
        proxy.initModules();
        assertEquals(DETECT, proxy.runDetect(1));

        ctest.disableTest();
    }

    @Test
    public void run_detect_Not_Exist_which_su_NOT_DETECT() {
        Ctest ctest = new Ctest();
        ctest.enableTest();
        ctest.setPopenCommandValue("which suaa");

        DetectModuleProxy proxy = new DetectModuleProxy();
        proxy.initModules();
        assertEquals(NOT_DETECT, proxy.runDetect(1));

        ctest.disableTest();
    }
}
