package com.jelly.datalayer.news;

import com.jelly.datalayer.ApiConfig;
import com.jelly.datalayer.CommonRequest;

public class NewsRemoteDataSource<T> implements NewsDataSource<T>{

    @Override
    public void getNews(T request, CommonRequest.CommonCallback callback) {
        CommonRequest.post(ApiConfig.NEW,request,callback);
    }

    @Override
    public void getNew(T request, CommonRequest.CommonCallback callback) {
        CommonRequest.post(ApiConfig.NEW,request,callback);
    }
}
