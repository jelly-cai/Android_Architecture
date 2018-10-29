package com.jelly.architecture.main;

import com.jelly.architecture.main.bean.NewsList;
import com.jelly.architecture.main.bean.NewsListRequest;
import com.jelly.architecture.net.ApiConfig;
import com.jelly.architecture.net.CommonRequest;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MainModel {

    @Inject
    public MainModel(){
    }

    public void getNews(CommonRequest.CommonCallback<NewsList> callback){
        NewsListRequest request = new NewsListRequest();
        request.setFunction(101);
        request.setPageIndex(1);
        request.setPageSize(10);
        request.setLastNewID(0);
        request.setDesc(0);
        request.setTreeID(27786);
        request.setMarket(2004);
        request.setCode("00763");
        request.setImgType(1);
        CommonRequest.post(ApiConfig.NEW, request, callback, NewsList.class);
    }

}
