package com.jelly.architecture.content;

import com.jelly.architecture.content.bean.NewContent;
import com.jelly.architecture.content.bean.NewContentRequest;
import com.jelly.architecture.net.ApiConfig;
import com.jelly.architecture.net.CommonRequest;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ReadNewModel {

    @Inject
    public ReadNewModel(){

    }

    public void getNewContent(int newId, CommonRequest.CommonCallback<NewContent> callback){
        NewContentRequest request = new NewContentRequest();
        request.setFunction(102);
        request.setNewID(newId + "");
        CommonRequest.post(ApiConfig.NEW,request,callback,NewContent.class);
    }

}
