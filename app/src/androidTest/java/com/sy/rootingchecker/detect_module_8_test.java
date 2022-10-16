package com.sy.rootingchecker;

import static com.sy.rootingchecker.AbstractDetectModule.DETECT;
import static com.sy.rootingchecker.AbstractDetectModule.NOT_DETECT;
import static com.sy.rootingchecker.test.Ctest.SYSTEM_PROPERTY_ID_RO_BUILD_SELINUX;
import static com.sy.rootingchecker.test.Ctest.SYSTEM_PROPERTY_ID_RO_DEBUGGABLE;
import static com.sy.rootingchecker.test.Ctest.SYSTEM_PROPERTY_ID_RO_SECURE;
import static com.sy.rootingchecker.test.Ctest.SYSTEM_PROPERTY_ID_SERVICE_ADB_ROOT;
import static com.sy.rootingchecker.test.Ctest.SYSTEM_PROPERTY_ID_SYS_INITD;
import static org.junit.Assert.assertEquals;

import com.sy.rootingchecker.test.Ctest;

import org.junit.Test;

import java.io.IOException;

public class detect_module_8_test {
    static {
        System.loadLibrary("detectEngine");
    }

    @Test
    public void run_detect_Check_RO_DEBUGGABLE_DETECT() throws IOException {
        Ctest ctest = new Ctest();
        ctest.enableTest();
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_RO_DEBUGGABLE,"1");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_SERVICE_ADB_ROOT,"1");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_RO_SECURE,"0");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_SYS_INITD,"0");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_RO_BUILD_SELINUX,"1");

        DetectModuleProxy proxy = new DetectModuleProxy();
        proxy.initModules();
        assertEquals(DETECT, proxy.runDetect(6));

        ctest.disableTest();
    }

    @Test
    public void run_detect_Check_RO_DEBUGGABLE_NOT_DETECT() throws IOException {
        Ctest ctest = new Ctest();
        ctest.enableTest();
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_RO_DEBUGGABLE,"0");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_SERVICE_ADB_ROOT,"1");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_RO_SECURE,"0");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_SYS_INITD,"0");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_RO_BUILD_SELINUX,"1");

        DetectModuleProxy proxy = new DetectModuleProxy();
        proxy.initModules();
        assertEquals(NOT_DETECT, proxy.runDetect(6));

        ctest.disableTest();
    }

    @Test
    public void run_detect_Check_SERVICE_ADB_ROOT_DETECT() throws IOException {
        Ctest ctest = new Ctest();
        ctest.enableTest();
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_RO_DEBUGGABLE,"0");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_SERVICE_ADB_ROOT,"0");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_RO_SECURE,"0");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_SYS_INITD,"0");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_RO_BUILD_SELINUX,"1");

        DetectModuleProxy proxy = new DetectModuleProxy();
        proxy.initModules();
        assertEquals(DETECT, proxy.runDetect(6));

        ctest.disableTest();
    }

    @Test
    public void run_detect_Check_SERVICE_ADB_ROOT_NOT_DETECT() throws IOException {
        Ctest ctest = new Ctest();
        ctest.enableTest();
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_RO_DEBUGGABLE,"0");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_SERVICE_ADB_ROOT,"1");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_RO_SECURE,"0");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_SYS_INITD,"0");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_RO_BUILD_SELINUX,"1");

        DetectModuleProxy proxy = new DetectModuleProxy();
        proxy.initModules();
        assertEquals(NOT_DETECT, proxy.runDetect(6));

        ctest.disableTest();
    }

    @Test
    public void run_detect_Check_RO_SECURE_DETECT() throws IOException {
        Ctest ctest = new Ctest();
        ctest.enableTest();
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_RO_DEBUGGABLE,"0");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_SERVICE_ADB_ROOT,"1");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_RO_SECURE,"1");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_SYS_INITD,"0");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_RO_BUILD_SELINUX,"1");

        DetectModuleProxy proxy = new DetectModuleProxy();
        proxy.initModules();
        assertEquals(DETECT, proxy.runDetect(6));

        ctest.disableTest();
    }

    @Test
    public void run_detect_Check_RO_SECURE_NOT_DETECT() throws IOException {
        Ctest ctest = new Ctest();
        ctest.enableTest();
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_RO_DEBUGGABLE,"0");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_SERVICE_ADB_ROOT,"1");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_RO_SECURE,"0");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_SYS_INITD,"0");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_RO_BUILD_SELINUX,"1");

        DetectModuleProxy proxy = new DetectModuleProxy();
        proxy.initModules();
        assertEquals(NOT_DETECT, proxy.runDetect(6));

        ctest.disableTest();
    }

    @Test
    public void run_detect_Check_SYS_INITD_DETECT() throws IOException {
        Ctest ctest = new Ctest();
        ctest.enableTest();
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_RO_DEBUGGABLE,"0");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_SERVICE_ADB_ROOT,"1");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_RO_SECURE,"0");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_SYS_INITD,"1");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_RO_BUILD_SELINUX,"1");

        DetectModuleProxy proxy = new DetectModuleProxy();
        proxy.initModules();
        assertEquals(DETECT, proxy.runDetect(6));

        ctest.disableTest();
    }

    @Test
    public void run_detect_Check_SYS_INITD_NOT_DETECT() throws IOException {
        Ctest ctest = new Ctest();
        ctest.enableTest();
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_RO_DEBUGGABLE,"0");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_SERVICE_ADB_ROOT,"1");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_RO_SECURE,"0");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_SYS_INITD,"0");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_RO_BUILD_SELINUX,"1");

        DetectModuleProxy proxy = new DetectModuleProxy();
        proxy.initModules();
        assertEquals(NOT_DETECT, proxy.runDetect(6));

        ctest.disableTest();
    }

    @Test
    public void run_detect_Check_RO_BUILD_SELINUX_DETECT() throws IOException {
        Ctest ctest = new Ctest();
        ctest.enableTest();
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_RO_DEBUGGABLE,"0");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_SERVICE_ADB_ROOT,"1");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_RO_SECURE,"0");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_SYS_INITD,"0");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_RO_BUILD_SELINUX,"0");

        DetectModuleProxy proxy = new DetectModuleProxy();
        proxy.initModules();
        assertEquals(DETECT, proxy.runDetect(6));

        ctest.disableTest();
    }

    @Test
    public void run_detect_Check_RO_BUILD_SELINUX_NOT_DETECT() throws IOException {
        Ctest ctest = new Ctest();
        ctest.enableTest();
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_RO_DEBUGGABLE,"0");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_SERVICE_ADB_ROOT,"1");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_RO_SECURE,"0");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_SYS_INITD,"0");
        ctest.setSystemPropertyValue(SYSTEM_PROPERTY_ID_RO_BUILD_SELINUX,"1");

        DetectModuleProxy proxy = new DetectModuleProxy();
        proxy.initModules();
        assertEquals(NOT_DETECT, proxy.runDetect(6));

        ctest.disableTest();
    }
}
