package com.jelly.datalayer.news;

import com.jelly.datalayer.CommonCallback;
import com.jelly.datalayer.CommonLocalRequest;

public class NewsLocalDataSource<T> implements NewsDataSource<T>{

    CommonLocalRequest localRequest;

    public NewsLocalDataSource(CommonLocalRequest localRequest){
        this.localRequest = localRequest;
    }

    @Override
    public void getNews(T request, CommonCallback callback) {
        localRequest.getJson(request.getClass().getSimpleName(),callback);
    }

    @Override
    public void getNew(T request, CommonCallback callback) {
        localRequest.getJson(request.getClass().getSimpleName(),callback);
    }

    public void saveNews(T request,String json){
        localRequest.putJson(request.getClass().getSimpleName(),json);
    }

}
