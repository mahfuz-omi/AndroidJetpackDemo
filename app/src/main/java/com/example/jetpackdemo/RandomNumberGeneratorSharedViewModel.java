package com.example.jetpackdemo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class RandomNumberGeneratorSharedViewModel extends ViewModel {
    private MutableLiveData<String> randomNumber;


    public MutableLiveData<String> getRandomNumber()
    {
        if(this.randomNumber == null)
        {
            this.randomNumber = this.createRandomNumber();
        }
        return this.randomNumber;
    }


    private MutableLiveData<String> createRandomNumber()
    {
        Random random = new Random();
        this.randomNumber = new MutableLiveData<>();
        this.randomNumber.setValue("number: "+random.nextInt()*100);
        return this.randomNumber;
    }

    public void changeData()
    {
        Random random = new Random();
        this.randomNumber.setValue("number: "+random.nextInt()*100);
    }
}
