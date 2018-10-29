package com.jelly.architecture.content;

import com.jelly.architecture.BasePresenter;
import com.jelly.architecture.BaseView;
import com.jelly.architecture.content.bean.NewContent;

public interface ReadNewContract {

    interface Presenter extends BasePresenter<View> {

    }

    interface View extends BaseView {
        void showContent(NewContent content);
    }

}
