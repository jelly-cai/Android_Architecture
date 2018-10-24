package com.jelly.datalayer.news;


import com.jelly.datalayer.CommonRequest;

public interface NewsDataSource<T> {
    void getNews(T request, CommonRequest.CommonCallback callback);
    void getNew(T request, CommonRequest.CommonCallback callback);
}
