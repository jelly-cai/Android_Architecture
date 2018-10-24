package com.jelly.architecture.main;

import com.jelly.architecture.BasePresenter;
import com.jelly.architecture.BaseView;
import com.jelly.domian.news.bean.NewsList;

public interface MainContract {

    interface View extends BaseView<Presenter> {
        void showNews(NewsList newsList);
        void refreshNews(NewsList newsList);
    }

    interface Presenter extends BasePresenter {
        void refreshNews();
    }

}
