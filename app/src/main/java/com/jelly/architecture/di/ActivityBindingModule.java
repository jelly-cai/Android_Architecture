package com.jelly.architecture.di;

import com.jelly.architecture.content.ReadNewActivity;
import com.jelly.architecture.content.ReadNewContract;
import com.jelly.architecture.content.ReadNewModule;
import com.jelly.architecture.main.MainModule;
import com.jelly.architecture.main.MvpMainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MvpMainActivity mvpMainActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = ReadNewModule.class)
    abstract ReadNewActivity readNewActivity();

}
