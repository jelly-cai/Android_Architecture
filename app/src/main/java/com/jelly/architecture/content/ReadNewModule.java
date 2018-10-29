package com.jelly.architecture.content;

import com.jelly.architecture.di.ActivityScoped;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class ReadNewModule {

    @ActivityScoped
    @Binds
    abstract ReadNewContract.Presenter readNewPresenter(ReadNewPresenter presenter);

    @ActivityScoped
    @Provides
    static int provideTaskId(ReadNewActivity activity){
        return activity.getIntent().getIntExtra(ReadNewActivity.NEWID_KEY, -1);
    }

}
