package com.jelly.datalayer;

public interface CommonCallback {

    void onResponse(String response);

    void onFail(int code, String message);

}