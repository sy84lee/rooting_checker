package com.sy.rootingchecker;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;

@RunWith(PowerMockRunner.class)
@PrepareForTest(DetectModule_1.class)
public class DetectModule_1_UnitTest {
    @Test
    public void runDetect_ExistSuperuserAPK_DETECT() throws Exception {
        File mockFile = PowerMockito.mock(File.class);
        when(mockFile.exists()).thenReturn(true);
        PowerMockito.whenNew(File.class).withArguments("/system/app/Superuser.apk").thenReturn(mockFile);

        DetectModule_1 detectModule_1 = new DetectModule_1("Check SuperuserAPK");
        assertEquals(AbstractDetectModule.DETECT, detectModule_1.runDetect().get(0).result);
    }

    @Test
    public void runDetect_NotExistSuperuserAPK_NOT_DETECT() throws Exception {
        File mockFile = PowerMockito.mock(File.class);
        when(mockFile.exists()).thenReturn(false);
        PowerMockito.whenNew(File.class).withArguments("/system/app/Superuser.apk").thenReturn(mockFile);

        DetectModule_1 detectModule_1 = new DetectModule_1("Check SuperuserAPK");
        assertEquals(AbstractDetectModule.NOT_DETECT, detectModule_1.runDetect().get(0).result);
    }

    @Test
    public void getTitle_SuperAPK_Success() {
        DetectModule_1 detectModule_1 = new DetectModule_1("SuperuserAPK");
        assertEquals("SuperuserAPK", detectModule_1.getTitle());
    }
}
