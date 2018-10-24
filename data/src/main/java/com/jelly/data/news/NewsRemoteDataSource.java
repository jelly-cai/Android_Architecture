package com.jelly.data.news;

import com.jelly.data.ApiConfig;
import com.jelly.data.CommonRequest;

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
