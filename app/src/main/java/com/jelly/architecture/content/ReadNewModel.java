package com.jelly.architecture.content;

import com.jelly.architecture.content.bean.NewContent;
import com.jelly.architecture.content.bean.NewContentRequest;
import com.jelly.architecture.net.ApiConfig;
import com.jelly.architecture.net.CommonRequest;


public class ReadNewModel {

    CommonRequest commonRequest;


    public ReadNewModel(CommonRequest commonRequest){
        this.commonRequest = commonRequest;
    }

    public void getNewContent(int newId, CommonRequest.CommonCallback<NewContent> callback){
        NewContentRequest request = new NewContentRequest();
        request.setFunction(102);
        request.setNewID(newId + "");
        commonRequest.post(ApiConfig.NEW,request,callback,NewContent.class);
    }

}
