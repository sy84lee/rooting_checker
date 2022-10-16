package com.sy.rootingchecker;

import static com.sy.rootingchecker.AbstractDetectModule.DETECT;
import static com.sy.rootingchecker.AbstractDetectModule.NOT_DETECT;
import static org.junit.Assert.assertEquals;

import com.sy.rootingchecker.test.Ctest;

import org.junit.Test;

import java.io.IOException;

public class detect_module_9_test {
    static {
        System.loadLibrary("detectEngine");
    }

    @Test
    public void run_detect_Exist_Magisk_File_DETECT() throws IOException {
        Ctest ctest = new Ctest();
        ctest.enableTest();
        ctest.setAccessReturnValue(0);

        DetectModuleProxy proxy = new DetectModuleProxy();
        proxy.initModules();
        assertEquals(DETECT, proxy.runDetect(7));

        ctest.disableTest();
    }

    @Test
    public void run_detect_Not_Exist_Magisk_File_NOT_DETECT() throws IOException {
        Ctest ctest = new Ctest();
        ctest.enableTest();
        ctest.setAccessReturnValue(1);

        DetectModuleProxy proxy = new DetectModuleProxy();
        proxy.initModules();
        assertEquals(NOT_DETECT, proxy.runDetect(7));

        ctest.disableTest();
    }
}
