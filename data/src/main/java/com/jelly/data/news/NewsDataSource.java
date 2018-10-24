package com.jelly.data.news;


import com.jelly.data.CommonRequest;

public interface NewsDataSource<T> {
    void getNews(T request, CommonRequest.CommonCallback callback);
    void getNew(T request, CommonRequest.CommonCallback callback);
}
