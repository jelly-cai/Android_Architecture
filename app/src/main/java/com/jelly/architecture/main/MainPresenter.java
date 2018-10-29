package com.jelly.architecture.main;

import android.util.Log;

import com.jelly.architecture.di.ActivityScoped;
import com.jelly.architecture.main.bean.NewsList;
import com.jelly.architecture.net.CommonRequest;

import javax.inject.Inject;


@ActivityScoped
public class MainPresenter implements MainContract.Presenter {

    private static final String TAG = "MainPresenter";
    @Inject
    MainModel mainModel;
    private MainContract.View view;

    @Inject
    MainPresenter() {
    }

    @Override
    public void takeView(MainContract.View view) {
        this.view = view;
        start();
    }


    private void start() {
        if (mainModel == null) return;
        mainModel.getNews(new CommonRequest.CommonCallback<NewsList>() {
            @Override
            public void onResponse(NewsList response) {
                Log.d(TAG, "onResponse: " + response);
                if (view == null) return;
                view.showNews(response);
            }

            @Override
            public void onFail(int code, String message) {

            }
        });
    }

    /**
     * 刷新
     */
    @Override
    public void refreshNews() {
        if (mainModel == null) return;
        mainModel.getNews(new CommonRequest.CommonCallback<NewsList>() {
            @Override
            public void onResponse(NewsList response) {
                if (view == null) return;
                view.refreshNews(response);
            }

            @Override
            public void onFail(int code, String message) {

            }
        });
    }

}
