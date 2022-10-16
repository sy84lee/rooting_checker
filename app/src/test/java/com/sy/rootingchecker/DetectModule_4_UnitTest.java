package com.sy.rootingchecker;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

@RunWith(PowerMockRunner.class)
@PrepareForTest(DetectModule_4.class)
public class DetectModule_4_UnitTest {
    @Test
    public void runDetect_CheckMount_DETECT() throws Exception {
        File testSuFile = new File("mounts");
        BufferedWriter writer = new BufferedWriter(new FileWriter(testSuFile));
        writer.write("tmpfs /system tmpfs rw,seclabel,nosuid,relatime,mode=755 0 0");
        writer.close();
        PowerMockito.whenNew(File.class).withArguments("/proc/mounts").thenReturn(testSuFile);

        DetectModule_4 detectModule_4 = new DetectModule_4("Check Mount Status");
        assertEquals(AbstractDetectModule.DETECT, detectModule_4.runDetect().get(0).result);

        testSuFile.delete();
    }

    @Test
    public void runDetect_CheckMount_NOT_DETECT() throws Exception {
        File testSuFile = new File("mounts");
        BufferedWriter writer = new BufferedWriter(new FileWriter(testSuFile));
        writer.write("tmpfs /dev tmpfs rw,seclabel,nosuid,relatime,mode=755 0 0");
        writer.close();
        PowerMockito.whenNew(File.class).withArguments("/proc/mounts").thenReturn(testSuFile);

        DetectModule_4 detectModule_4 = new DetectModule_4("Check Mount Status");
        assertEquals(AbstractDetectModule.NOT_DETECT, detectModule_4.runDetect().get(0).result);

        testSuFile.delete();
    }

    @Test
    public void getTitle_test_keys_Success() {
        DetectModule_2 detectModule_2 = new DetectModule_2("Check Mount Status");
        assertEquals("Check Mount Status", detectModule_2.getTitle());
    }
}
