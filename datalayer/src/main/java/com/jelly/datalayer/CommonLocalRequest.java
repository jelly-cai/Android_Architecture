package com.jelly.datalayer;



import com.jelly.tool.Codes;
import com.jelly.tool.JsonUtils;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CommonRemoteRequest {

    private static OkHttpClient client;

    static {
        client = new OkHttpClient.Builder().connectTimeout(10,TimeUnit.SECONDS).build();
    }

    private static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public static void post(String url, Object questBean, final CommonCallback callback) {
        RequestBody body = RequestBody.create(JSON, JsonUtils.beanToJson(questBean));
        final Request request = new Request.Builder().url(url).post(body).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFail(Codes.NET_ERROR, "网络请求异常");
            }

            @Override
            public void onResponse(Call call,Response response) throws IOException {
                if (response.body() != null) {
                    callback.onResponse(response.body().string());
                } else {
                    callback.onFail(Codes.CONTENT_EMPTY, "响应内容为空");
                }

            }
        });
    }


    public interface CommonCallback {

        void onResponse(String response);

        void onFail(int code, String message);

    }

}
