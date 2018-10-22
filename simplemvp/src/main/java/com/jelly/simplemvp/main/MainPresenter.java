package com.jelly.simplemvp.main;

import android.util.Log;

import com.jelly.simplemvp.main.bean.NewsList;
import com.jelly.simplemvp.net.CommonRequest;

public class MainPresenter implements MainContract.Presenter {

    private static final String TAG = "MainPresenter";

    private MainModel mainModel;
    private MainContract.View view;

    MainPresenter(MainModel mainModel, MainContract.View view) {
        this.mainModel = mainModel;
        this.view = view;
    }

    @Override
    public void start() {
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
