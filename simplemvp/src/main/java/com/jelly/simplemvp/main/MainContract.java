package com.jelly.simplemvp.main;

import com.jelly.simplemvp.BasePresenter;
import com.jelly.simplemvp.BaseView;
import com.jelly.simplemvp.main.bean.NewsList;

public interface MainContract {

    interface View extends BaseView<Presenter> {
        void showNews(NewsList newsList);
    }

    interface Presenter extends BasePresenter {

    }

}
