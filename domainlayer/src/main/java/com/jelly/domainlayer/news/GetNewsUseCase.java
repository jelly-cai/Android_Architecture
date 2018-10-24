package com.jelly.domainlayer.news;

import com.jelly.datalayer.CommonRequest;
import com.jelly.datalayer.news.NewsRemoteDataSource;
import com.jelly.domainlayer.UseCase;
import com.jelly.domainlayer.news.bean.NewsList;
import com.jelly.domainlayer.news.bean.NewsListRequest;
import com.jelly.tool.JsonUtils;

public class GetNewsUseCase extends UseCase<NewsListRequest,NewsList> {

    private final NewsRemoteDataSource<NewsListRequest> dataSource = new NewsRemoteDataSource<>();

    public GetNewsUseCase() {
    }

    @Override
    public void execute(NewsListRequest request) {
        dataSource.getNews(request, new CommonRequest.CommonCallback() {
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
