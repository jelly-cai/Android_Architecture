package com.jelly.domian.news;

import com.jelly.data.CommonRequest;
import com.jelly.data.news.NewsRemoteDataSource;
import com.jelly.data.util.JsonUtils;
import com.jelly.domian.UseCase;
import com.jelly.domian.news.bean.NewContent;
import com.jelly.domian.news.bean.NewContentRequest;

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
