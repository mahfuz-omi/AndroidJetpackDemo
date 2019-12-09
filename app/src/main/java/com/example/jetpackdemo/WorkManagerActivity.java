package com.example.jetpackdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class WorkManagerActivity extends AppCompatActivity {

    TextView workStatusTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_manager);

        this.workStatusTextView = this.findViewById(R.id.workStatusTextView);

    }

    public void startWork(View view) {

        //This is the subclass of our WorkRequest
        Data data = new Data.Builder()
                .putString("description", "The task data passed from WorkManagerActivity")
                .build();

        OneTimeWorkRequest workRequest = new OneTimeWorkRequest.Builder(MyWorker.class)
                .setInputData(data)
                .build();

        WorkManager.getInstance().enqueue(workRequest);
        WorkManager.getInstance().getWorkInfoByIdLiveData(workRequest.getId()).observe(WorkManagerActivity.this, new Observer<WorkInfo>() {
            @Override
            public void onChanged(WorkInfo workInfo) {
                String status = workInfo.getState().name();
                workStatusTextView.append(status+"\n");
                if(workInfo.getState().isFinished())
                {
                    Toast.makeText(WorkManagerActivity.this, workInfo.getOutputData().getString("output"), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
