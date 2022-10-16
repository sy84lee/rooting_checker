package com.sy.rootingchecker;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import android.os.Build;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

@RunWith(PowerMockRunner.class)
@PrepareForTest(DetectModule_2.class)
public class DetectModule_2_UnitTest {

    @Test
    public void runDetect_Build_Tag_Equals_test_keys_DETECT() {
        Whitebox.setInternalState(Build.class, "TAGS", "test-keys");

        DetectModule_2 detectModule_2 = new DetectModule_2("Check Build.prop: test-key");
        assertEquals(AbstractDetectModule.DETECT, detectModule_2.runDetect().get(0).result);
    }

    @Test
    public void runDetect_Build_Tag_Not_Equals_test_keys_NOT_DETECT() {
        Whitebox.setInternalState(Build.class, "TAGS", "release-keys");

        DetectModule_2 detectModule_2 = new DetectModule_2("Check Build.prop: test-key");
        assertEquals(AbstractDetectModule.NOT_DETECT, detectModule_2.runDetect().get(0).result);
    }

    @Test
    public void getTitle_test_keys_Success() {
        DetectModule_2 detectModule_2 = new DetectModule_2("test-keys");
        assertEquals("test-keys", detectModule_2.getTitle());
    }
}
