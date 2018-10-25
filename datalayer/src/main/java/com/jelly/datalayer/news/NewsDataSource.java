package com.jelly.datalayer.news;


import com.jelly.datalayer.CommonCallback;

public interface NewsDataSource<T> {
    void getNews(T request, CommonCallback callback);
    void getNew(T request, CommonCallback callback);
}
