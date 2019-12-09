package com.example.jetpackdemo;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("owner onCreate");

        getLifecycle().addObserver(new MainActivityLifeCycleObserver());

    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("owner onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("owner onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("owner onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("owner onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("owner onDestroy");
    }
}
