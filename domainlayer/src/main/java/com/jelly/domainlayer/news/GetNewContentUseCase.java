package com.jelly.domainlayer.news;

import com.jelly.datalayer.CommonRequest;
import com.jelly.datalayer.news.NewsRemoteDataSource;
import com.jelly.domainlayer.UseCase;
import com.jelly.domainlayer.news.bean.NewContent;
import com.jelly.domainlayer.news.bean.NewContentRequest;
import com.jelly.tool.JsonUtils;

public class GetNewContentUseCase extends UseCase<NewContentRequest, NewContent> {
    private final NewsRemoteDataSource<NewContentRequest> dataSource = new NewsRemoteDataSource<>();

    public GetNewContentUseCase() {
    }

    @Override
    public void execute(NewContentRequest request) {
        dataSource.getNew(request, new CommonRequest.CommonCallback() {
            @Override
            public void onResponse(String response) {
                getCallBack().onSuccess(JsonUtils.jsonToBean(response,NewContent.class));
            }

            @Override
            public void onFail(int code, String message) {
                getCallBack().onFail(code,message);
            }
        });
    }

    public NewContentRequest createNewContent(int newId){
        NewContentRequest request = new NewContentRequest();
        request.setFunction(102);
        request.setNewID(newId + "");
        return request;
    }

}
