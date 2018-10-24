package com.jelly.data;


import com.jelly.data.util.JsonUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CommonRequest {

    private static OkHttpClient client = new OkHttpClient();
    private static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public static void post(String url, Object questBean, final CommonCallback callback) {
        RequestBody body = RequestBody.create(JSON, JsonUtils.beanToJson(questBean));
        final Request request = new Request.Builder().url(url).post(body).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
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
