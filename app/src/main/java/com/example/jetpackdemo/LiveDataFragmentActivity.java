package com.example.jetpackdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LiveDataFragmentActivity extends AppCompatActivity {
    TextView dataTextView;
    Button changeDataButton;

    RandomNumberGeneratorSharedViewModel randomNumberGeneratorSharedViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data_fragment);

        this.dataTextView = this.findViewById(R.id.dataTextView);
        this.changeDataButton = this.findViewById(R.id.changeDataButton);

        this.randomNumberGeneratorSharedViewModel = ViewModelProviders.of(this).get(RandomNumberGeneratorSharedViewModel.class);
        this.randomNumberGeneratorSharedViewModel.getRandomNumber().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                dataTextView.setText(s);
            }
        });

        this.changeDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomNumberGeneratorSharedViewModel.changeData();
            }
        });


    }
}
