package com.sy.rootingchecker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView result_text;
        result_text = (TextView)findViewById(R.id.textView);
        button = (Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    Controller controller = new Controller();
                    int value = controller.startDetect();

                    if (value != 0)
                        result_text.setText("ROOTED");
                    else
                        result_text.setText("NOT ROOTED");
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