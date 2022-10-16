package com.sy.rootingchecker;

import static com.sy.rootingchecker.AbstractDetectModule.DETECT;
import static com.sy.rootingchecker.AbstractDetectModule.NOT_DETECT;
import static com.sy.rootingchecker.test.Ctest.SYSTEM_PROPERTY_ID_ANDROID_OS_BUILD_TAGS;
import static org.junit.Assert.assertEquals;

import com.sy.rootingchecker.test.Ctest;

import org.junit.Test;

import java.io.IOException;

public class detect_module_6_test {
    static {
        System.loadLibrary("detectEngine");
    }

    @Test
    public void run_detect_Check_dev_keys_DETECT() throws IOException {
        Ctest ctest = new Ctest();
        ctest.enableTest();
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_ANDROID_OS_BUILD_TAGS, "dev-keys");

        DetectModuleProxy proxy = new DetectModuleProxy();
        proxy.initModules();
        assertEquals(DETECT, proxy.runDetect(5));

        ctest.disableTest();
    }

    @Test
    public void run_detect_Check_dev_keys_NOT_DETECT() throws IOException {
        Ctest ctest = new Ctest();
        ctest.enableTest();
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_ANDROID_OS_BUILD_TAGS, "release-keys");

        DetectModuleProxy proxy = new DetectModuleProxy();
        proxy.initModules();
        assertEquals(NOT_DETECT, proxy.runDetect(5));

        ctest.disableTest();
    }
}
