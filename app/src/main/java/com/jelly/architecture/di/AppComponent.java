package com.jelly.architecture.di;


import com.jelly.architecture.MyApplication;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, AppModule.class, ActivityBindingModule.class})
public interface AppComponent extends AndroidInjector<MyApplication> {

    abstract class Builder extends AndroidInjector.Builder<MyApplication> {
    }

}
