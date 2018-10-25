package com.jelly.datalayer.news;

import com.jelly.datalayer.CommonCallback;
import com.jelly.datalayer.Repository;
import com.jelly.tool.Codes;

import static com.jelly.tool.RequestMethod.LOCAL_ONLY;
import static com.jelly.tool.RequestMethod.LOCAL_REMOTE_CACHE;
import static com.jelly.tool.RequestMethod.REMOTE_ONLY;

public class NewsRepository<T> extends Repository implements NewsDataSource<T>{

    private NewsLocalDataSource<T> localDataSource;
    private NewsRemoteDataSource<T> remoteDataSource;

    public NewsRepository(NewsLocalDataSource<T> localDataSource,NewsRemoteDataSource<T> remoteDataSource){
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public void getNews(final T request, final CommonCallback callback) {
        if(getMethod() == LOCAL_REMOTE_CACHE){
            localDataSource.getNews(request, new CommonCallback() {
                @Override
                public void onResponse(String response) {
                    callback.onResponse(response);
                }

                @Override
                public void onFail(int code, String message) {
                    if(code == Codes.CONTENT_EMPTY){
                        requestNewsRemoteData(request,callback);
                    }
                }
            });
        }else if(getMethod() == LOCAL_ONLY){
            localDataSource.getNews(request,callback);
        }else if(getMethod() == REMOTE_ONLY){
            requestNewsRemoteData(request,callback);
        }
    }

    @Override
    public void getNew(T request, CommonCallback callback) {
        remoteDataSource.getNew(request,callback);
    }

    private void requestNewsRemoteData(final T request, final CommonCallback callback){
        remoteDataSource.getNews(request, new CommonCallback() {
            @Override
            public void onResponse(String response) {
                if(getMethod() == LOCAL_REMOTE_CACHE){
                    localDataSource.saveNews(request,response);
                }
                callback.onResponse(response);
            }

            @Override
            public void onFail(int code, String message) {
                callback.onFail(code,message);
            }
        });
    }

}
