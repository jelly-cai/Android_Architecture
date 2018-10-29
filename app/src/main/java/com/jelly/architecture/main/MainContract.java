package com.jelly.architecture.main;

import com.jelly.architecture.BasePresenter;
import com.jelly.architecture.BaseView;
import com.jelly.architecture.main.bean.NewsList;

public interface MainContract {

    interface View extends BaseView {
        void showNews(NewsList newsList);
        void refreshNews(NewsList newsList);
    }

    interface Presenter extends BasePresenter<View> {
        void refreshNews();
    }

}
