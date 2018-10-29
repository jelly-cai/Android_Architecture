package com.jelly.architecture.main;

import com.jelly.architecture.di.ActivityScoped;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MainModule {

    @ActivityScoped
    @Binds
    abstract MainContract.Presenter mainPresenter(MainPresenter presenter);
}
