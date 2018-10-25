package com.jelly.domainlayer.news;

import android.content.Context;

import com.jelly.datalayer.CommonCallback;
import com.jelly.datalayer.CommonLocalRequest;
import com.jelly.datalayer.CommonRemoteRequest;
import com.jelly.datalayer.Repository;
import com.jelly.datalayer.news.NewsLocalDataSource;
import com.jelly.datalayer.news.NewsRemoteDataSource;
import com.jelly.datalayer.news.NewsRepository;
import com.jelly.domainlayer.UseCase;
import com.jelly.domainlayer.news.bean.NewContent;
import com.jelly.domainlayer.news.bean.NewContentRequest;
import com.jelly.domainlayer.news.bean.NewsListRequest;
import com.jelly.tool.JsonUtils;

public class GetNewContentUseCase extends UseCase<NewContentRequest, NewContent> {
    private final NewsRepository<NewContentRequest> newsRepository;

    public GetNewContentUseCase(Context context) {
        super(context);
        newsRepository = new NewsRepository<>(new NewsLocalDataSource<NewContentRequest>(new CommonLocalRequest(context)),new NewsRemoteDataSource<NewContentRequest>());
    }

    @Override
    public void execute(NewContentRequest request) {
        newsRepository.getNew(request, new CommonCallback() {
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

    @Override
    public void setMethod(int method) {
        newsRepository.setMethod(method);
    }

    public NewContentRequest createNewContent(int newId){
        NewContentRequest request = new NewContentRequest();
        request.setFunction(102);
        request.setNewID(newId + "");
        return request;
    }

}
