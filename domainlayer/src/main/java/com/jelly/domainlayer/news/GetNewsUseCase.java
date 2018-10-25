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
import com.jelly.domainlayer.news.bean.NewsList;
import com.jelly.domainlayer.news.bean.NewsListRequest;
import com.jelly.tool.JsonUtils;

public class GetNewsUseCase extends UseCase<NewsListRequest,NewsList> {

    private final NewsRepository<NewsListRequest> newsRepository;

    public GetNewsUseCase(Context context) {
        super(context);
        newsRepository = new NewsRepository<>(new NewsLocalDataSource<NewsListRequest>(new CommonLocalRequest(context)),new NewsRemoteDataSource<NewsListRequest>());
    }

    @Override
    public void execute(NewsListRequest request) {
        newsRepository.getNews(request, new CommonCallback() {
            @Override
            public void onResponse(String response) {
                getCallBack().onSuccess(JsonUtils.jsonToBean(response,NewsList.class));
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

    public NewsListRequest createNewsListRequest(){
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
        return request;
    }

}
