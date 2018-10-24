package com.jelly.architecture.util;

import com.google.gson.Gson;

public class JsonUtils {

    static Gson gson = new Gson();

    public static String beanToJson(Object o){
        return gson.toJson(o);
    }

    public static <T> T jsonToBean(String json,Class<T> tClass){
        return gson.fromJson(json,tClass);
    }

}
