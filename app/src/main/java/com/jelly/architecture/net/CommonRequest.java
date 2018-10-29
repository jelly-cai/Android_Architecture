package com.jelly.architecture.net;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import com.jelly.architecture.util.JsonUtils;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Singleton
public class CommonRequest {

    private OkHttpClient client = new OkHttpClient();
    private MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private Handler mainHandler = new Handler(Looper.getMainLooper());

    @Inject
    public CommonRequest() {
    }

    public <T> void post(String url, Object questBean, final CommonCallback<T> callback, final Class<T> tClass) {
        RequestBody body = RequestBody.create(JSON, JsonUtils.beanToJson(questBean));
        final Request request = new Request.Builder().url(url).post(body).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, final @NonNull Response response) {
                mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            if (response.body() != null) {
                                callback.onResponse(JsonUtils.jsonToBean(response.body().string(), tClass));
                            } else {
                                callback.onFail(Codes.CONTENT_EMPTY, "响应内容为空");
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

            }
        });
    }


    public interface CommonCallback<T> {

        void onResponse(T response);

        void onFail(int code, String message);

    }

}
