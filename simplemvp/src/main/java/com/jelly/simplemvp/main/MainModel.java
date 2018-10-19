package com.jelly.simplemvp.main;

import com.jelly.simplemvp.main.bean.NewsList;
import com.jelly.simplemvp.main.bean.NewsListRequest;
import com.jelly.simplemvp.net.ApiConfig;
import com.jelly.simplemvp.net.CommonRequest;

public class MainModel {

    public static final String TAG = "MainModel";

    public void getNews(CommonRequest.MyCallback<NewsList> callback){
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
        CommonRequest.post(ApiConfig.GET_NEWS, request, callback, NewsList.class);
    }

}
