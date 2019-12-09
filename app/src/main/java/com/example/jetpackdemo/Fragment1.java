package com.example.jetpackdemo;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment1} interface
 * to handle interaction events.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {

    TextView dataTextView;

    RandomNumberGeneratorSharedViewModel randomNumberGeneratorSharedViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fragment1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.dataTextView = this.getView().findViewById(R.id.dataTextView);

        this.randomNumberGeneratorSharedViewModel = ViewModelProviders.of(getActivity()).get(RandomNumberGeneratorSharedViewModel.class);
        this.randomNumberGeneratorSharedViewModel.getRandomNumber().observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                dataTextView.setText(s);
            }
        });
    }
}
