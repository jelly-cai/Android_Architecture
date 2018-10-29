package com.jelly.architecture.di;


import android.app.Application;

import com.jelly.architecture.MyApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, AppModule.class, ActivityBindingModule.class})
public interface AppComponent extends AndroidInjector<MyApplication> {

    @Component.Builder
    interface Builder{

        @BindsInstance
        AppComponent.Builder application(MyApplication application);

        AppComponent build();

    }

}
