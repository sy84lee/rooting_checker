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
            }
        });
      }

}