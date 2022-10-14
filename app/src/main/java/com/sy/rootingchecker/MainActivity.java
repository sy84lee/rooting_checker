package com.sy.rootingchecker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button button;
    RecyclerView detectResults;
    ResultViewAdapter rvAdapter;
    ArrayList<DetectResult> resultList = new ArrayList<DetectResult>();
    Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = new Controller();
        detectResults = (RecyclerView)findViewById(R.id.recycler_expense);
        rvAdapter = new ResultViewAdapter(resultList);
        detectResults.setAdapter(rvAdapter);
        detectResults.setLayoutManager(new LinearLayoutManager(this));

        button = (Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    resultList.clear();
                    resultList.addAll(controller.startDetect());
                    rvAdapter.notifyDataSetChanged();
                } catch (Exception e) {
                    e.printStackTrace();
                }

//                Runtime runtime = Runtime.getRuntime();
//                String cmd = "/system/bin/which su";
//                //String cmd = "ls /system/xbin/";
//                Process process = null;
//                try {
//                    process = runtime.exec(cmd);
//                    process.waitFor();
//                    BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
//                    String line ;
//                    while ((line = br.readLine()) != null) {
//                        Log.i("test",line);
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    Log.e("Process Manager", "Unable to execute top command");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//
//                }

            }
        });
      }

}