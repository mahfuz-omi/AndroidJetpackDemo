package com.example.jetpackdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.EditText;

public class ViewModelActivity extends AppCompatActivity {
    EditText nameEditText;

    private ViewModelActivityViewModel viewModelActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model);

        this.nameEditText = this.findViewById(R.id.nameEditText);

        // Get the ViewModel.
        this.viewModelActivityViewModel = ViewModelProviders.of(this).get(ViewModelActivityViewModel.class);

        // Create the observer which updates the UI.
        final Observer<String> nameObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String newName) {
                // Update the UI, in this case, an edittext.
                System.out.println("text changed");
                nameEditText.setText(newName);
            }
        };

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        viewModelActivityViewModel.getCurrentName().observe(this, nameObserver);
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
