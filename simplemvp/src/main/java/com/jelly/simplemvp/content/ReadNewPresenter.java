package com.jelly.simplemvp.content;
import android.support.annotation.NonNull;

import com.jelly.simplemvp.content.bean.NewContent;
import com.jelly.simplemvp.net.CommonRequest;

public class ReadNewPresenter implements ReadNewContract.Presenter {

    private ReadNewModel model;
    private ReadNewContract.View view;
    private int newId;

    public ReadNewPresenter(@NonNull ReadNewModel model,@NonNull ReadNewContract.View view,@NonNull int newId) {
        this.model = model;
        this.view = view;
        this.newId = newId;
    }

    @Override
    public void start() {
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

}
