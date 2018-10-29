package com.jelly.architecture.content;
import com.jelly.architecture.content.bean.NewContent;
import com.jelly.architecture.di.ActivityScoped;
import com.jelly.architecture.net.CommonRequest;

import javax.inject.Inject;

@ActivityScoped
public class ReadNewPresenter implements ReadNewContract.Presenter {

    @Inject
    ReadNewModel model;
    private ReadNewContract.View view;
    @Inject
    int newId;

    @Inject
    public ReadNewPresenter() {
    }

    private void start() {
        if(model == null){
            return;
        }
        model.getNewContent(newId, new CommonRequest.CommonCallback<NewContent>() {
            @Override
            public void onResponse(NewContent response) {
                if(view == null) return;
                view.showContent(response);
            }

            @Override
            public void onFail(int code, String message) {

            }
        });
    }

    @Override
    public void takeView(ReadNewContract.View view) {
        this.view = view;
        start();
    }
}
