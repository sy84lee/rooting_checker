package com.sy.rootingchecker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DetectModule_4 extends AbstractDetectModule {

    private String READ_ONLY_PATH[] = { "/system",
                                        "/system/bin",
                                        "/system/sbin",
                                        "/system/xbin",
                                        "/vendor/bin",
                                        "/sbin",
                                        "/etc",
                                        };

    public DetectModule_4(String _title) {
        title = _title;
    }

    @Override
    public ArrayList<DetectResult> runDetect() {
        ArrayList<DetectResult> result = new ArrayList<DetectResult>();
        try {
            File file = new File("/proc/mounts");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                for (String path : READ_ONLY_PATH) {
                    if (words[1].equalsIgnoreCase(path)) {
                        String[] opts = words[3].split(",");
                        for (String op : opts) {
                            if (op.equalsIgnoreCase("rw")) {
                                result.add(new DetectResult(title, DETECT));
                                return result;
                            }
                        }
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        result.add(new DetectResult(title, NOT_DETECT));
        return result;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
