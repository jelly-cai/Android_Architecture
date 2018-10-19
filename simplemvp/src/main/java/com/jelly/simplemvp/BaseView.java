package com.jelly.simplemvp;


public interface BaseView<T> {
    void setPresenter(T presenter);
}
