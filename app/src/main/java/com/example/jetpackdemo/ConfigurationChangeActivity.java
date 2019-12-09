package com.example.jetpackdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.TextView;

public class ConfigurationChangeActivity extends AppCompatActivity {
    TextView randomNumberTextView;
    RandomNumberGeneratorSharedViewModel randomNumberGeneratorSharedViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration_change);
        System.out.println("owner onCreate");

        this.randomNumberTextView = this.findViewById(R.id.randomNumberTextView);
        this.randomNumberGeneratorSharedViewModel = ViewModelProviders.of(this).get(RandomNumberGeneratorSharedViewModel.class);
        //this.randomNumberTextView.setText(this.randomNumberGeneratorSharedViewModel.getRandomNumber());
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
