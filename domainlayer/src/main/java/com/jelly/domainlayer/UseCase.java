package com.jelly.domainlayer;

import android.content.Context;

public abstract class UseCase<R, T> {

    private UseCaseCallBack<T> callBack;
    private Context context;

    public UseCase(Context context){
        this.context = context;
    }

    public abstract void execute(R request);

    /**
     * 设置请求方式
     * @param method
     */
    public abstract void setMethod(int method);

    public void setCallBack(UseCaseCallBack<T> callBack) {
        this.callBack = callBack;
    }

    public UseCaseCallBack<T> getCallBack() {
        return callBack;
    }

    public interface UseCaseCallBack<T> {
        void onSuccess(T response);

        void onFail(int code, String message);
    }

}
