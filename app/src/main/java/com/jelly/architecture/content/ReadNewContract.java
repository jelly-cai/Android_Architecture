package com.jelly.architecture.content;

import com.jelly.architecture.BasePresenter;
import com.jelly.architecture.BaseView;
import com.jelly.architecture.content.bean.NewContent;

public interface ReadNewContract {

    interface Presenter extends BasePresenter {

    }

    interface View extends BaseView<Presenter> {
        void showContent(NewContent content);
    }

}
