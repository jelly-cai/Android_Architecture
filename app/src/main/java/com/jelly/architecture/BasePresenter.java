package com.jelly.architecture;

public interface BasePresenter<T> {
    void takeView(T view);
}
