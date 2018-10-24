package com.jelly.architecture.content;
import android.support.annotation.NonNull;

import com.jelly.architecture.UseCaseHandler;
import com.jelly.domainlayer.UseCase;
import com.jelly.domainlayer.news.GetNewContentUseCase;
import com.jelly.domainlayer.news.bean.NewContent;
import com.jelly.domainlayer.news.bean.NewContentRequest;

public class ReadNewPresenter implements ReadNewContract.Presenter {

    private UseCaseHandler useCaseHandler;
    private GetNewContentUseCase getNewContentUseCase;
    private ReadNewContract.View view;
    private int newId;

    public ReadNewPresenter(UseCaseHandler handler,@NonNull GetNewContentUseCase getNewContentUseCase, @NonNull ReadNewContract.View view, @NonNull int newId) {
        this.useCaseHandler = handler;
        this.getNewContentUseCase = getNewContentUseCase;
        this.view = view;
        this.newId = newId;
    }

    @Override
    public void start() {
        NewContentRequest request = getNewContentUseCase.createNewContent(newId);
        useCaseHandler.execute(getNewContentUseCase, request, new UseCase.UseCaseCallBack<NewContent>() {
            @Override
            public void onSuccess(NewContent response) {
                if(view == null) return;
                view.showContent(response);
            }

            @Override
            public void onFail(int code, String message) {
                if(view != null){
                    view.httpFail(code,message);
                }
            }
        });
    }

}
