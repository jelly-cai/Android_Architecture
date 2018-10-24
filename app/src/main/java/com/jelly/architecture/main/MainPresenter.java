package com.jelly.architecture.main;


import com.jelly.architecture.UseCaseHandler;
import com.jelly.domainlayer.UseCase;
import com.jelly.domainlayer.news.GetNewsUseCase;
import com.jelly.domainlayer.news.bean.NewsList;
import com.jelly.domainlayer.news.bean.NewsListRequest;

public class MainPresenter implements MainContract.Presenter {

    private static final String TAG = "MainPresenter";

    private UseCaseHandler useCaseHandler;
    private GetNewsUseCase getNewsUseCase;
    private MainContract.View view;

    MainPresenter(UseCaseHandler useCaseHandler,GetNewsUseCase getNewsUseCase, MainContract.View view) {
        this.useCaseHandler = useCaseHandler;
        this.getNewsUseCase = getNewsUseCase;
        this.view = view;
    }

    @Override
    public void start() {
        if (getNewsUseCase == null) return;
        NewsListRequest request = getNewsUseCase.createNewsListRequest();
        useCaseHandler.execute(getNewsUseCase, request, new UseCase.UserCaseCallBack<NewsList>() {
            @Override
            public void onSuccess(NewsList response) {
                if (view != null) {
                    view.showNews(response);
                }
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
        if (getNewsUseCase == null) return;
        NewsListRequest request = getNewsUseCase.createNewsListRequest();
        useCaseHandler.execute(getNewsUseCase, request, new UseCase.UserCaseCallBack<NewsList>() {
            @Override
            public void onSuccess(NewsList response) {
                if (view != null) {
                    view.refreshNews(response);
                }
            }

            @Override
            public void onFail(int code, String message) {

            }
        });
    }

}
