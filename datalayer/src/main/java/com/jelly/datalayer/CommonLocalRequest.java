package com.jelly.datalayer;



import android.content.Context;
import android.text.TextUtils;

import com.jelly.timecache.TimeCache;
import com.jelly.tool.Codes;

import java.sql.Time;

import static com.jelly.tool.Codes.LOCAL_ERROR;

public class CommonLocalRequest {

    TimeCache timeCache;

    public CommonLocalRequest(Context context){
        timeCache = TimeCache.newTimeCache(context);
    }

    public void putJson(String key,String json){
        timeCache.put(key,json);
    }

    public void getJson(String key,CommonCallback callback){
        String json = null;
        try {
            json = timeCache.getString(key);
            callback.onResponse(json);
        }catch (Exception e){
            callback.onFail(LOCAL_ERROR,"获取本地缓存数据错误");
        }finally {
            if(TextUtils.isEmpty(json)){
                callback.onFail(Codes.CONTENT_EMPTY,"内容为空");
            }
        }
    }


}
