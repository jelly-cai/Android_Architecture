package com.jelly.datalayer.news;

import com.jelly.datalayer.ApiConfig;
import com.jelly.datalayer.CommonCallback;
import com.jelly.datalayer.CommonRemoteRequest;

public class NewsRemoteDataSource<T> implements NewsDataSource<T>{

    @Override
    public void getNews(T request, CommonCallback callback) {
        CommonRemoteRequest.post(ApiConfig.NEW,request,callback);
    }

    @Override
    public void getNew(T request, CommonCallback callback) {
        CommonRemoteRequest.post(ApiConfig.NEW,request,callback);
    }
}
