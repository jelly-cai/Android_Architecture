package com.jelly.simplemvp.content;

import com.jelly.simplemvp.BasePresenter;
import com.jelly.simplemvp.BaseView;
import com.jelly.simplemvp.content.bean.NewContent;

public interface ReadNewContract {

    interface Presenter extends BasePresenter{

    }

    interface View extends BaseView {
        void showContent(NewContent content);
    }

}
