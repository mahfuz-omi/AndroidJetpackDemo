package com.example.jetpackdemo;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;

public class CustomLifeCycleOwner implements LifecycleOwner {

    LifecycleRegistry lifecycleRegistry;

    public CustomLifeCycleOwner()
    {
        lifecycleRegistry = new LifecycleRegistry(this);
        this.lifecycleRegistry.setCurrentState(Lifecycle.State.INITIALIZED);
    }


    @Override
    public Lifecycle getLifecycle() {
        return this.lifecycleRegistry;
    }

    public void onFunction1()
    {
        this.lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
    }

    public void onFunction2()
    {
        this.lifecycleRegistry.setCurrentState(Lifecycle.State.STARTED);
    }

    public void onFunction3()
    {
        this.lifecycleRegistry.setCurrentState(Lifecycle.State.DESTROYED);
    }
}
