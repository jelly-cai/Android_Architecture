package com.jelly.architecture.main;

import com.jelly.architecture.di.ActivityScoped;
import com.jelly.architecture.net.CommonRequest;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class MainModule {

    @ActivityScoped
    @Binds
    abstract MainContract.Presenter mainPresenter(MainPresenter presenter);

    @ActivityScoped
    @Provides
    static MainModel provideMainModel(CommonRequest commonRequest){
        return new MainModel(commonRequest);
    }

}
