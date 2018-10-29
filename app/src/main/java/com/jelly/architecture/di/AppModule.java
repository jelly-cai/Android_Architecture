package com.jelly.architecture.di;

import android.app.Application;
import android.content.Context;

import com.jelly.architecture.MyApplication;
import com.jelly.architecture.util.ToastUtils;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class AppModule {
    @Binds
    abstract Context bindContext(MyApplication application);

    @Singleton
    @Provides
    static ToastUtils provideToastUtils(Context context){
        return new ToastUtils(context);
    }

}
