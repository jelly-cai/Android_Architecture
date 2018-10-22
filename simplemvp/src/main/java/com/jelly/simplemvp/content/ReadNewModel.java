package com.jelly.simplemvp.content;

import com.jelly.simplemvp.content.bean.NewContent;
import com.jelly.simplemvp.content.bean.NewContentRequest;
import com.jelly.simplemvp.net.ApiConfig;
import com.jelly.simplemvp.net.CommonRequest;

public class ReadNewModel {

    public void getNewContent(int newId, CommonRequest.CommonCallback<NewContent> callback){
        NewContentRequest request = new NewContentRequest();
        request.setFunction(102);
        request.setNewID(newId + "");
        CommonRequest.post(ApiConfig.NEW,request,callback,NewContent.class);
    }

}
