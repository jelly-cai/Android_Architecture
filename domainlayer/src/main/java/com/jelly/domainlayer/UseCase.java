package com.jelly.domainlayer;

public abstract class UseCase<R,T> {

    private UseCaseCallBack<T> callBack;

    public interface UseCaseCallBack<T> {
        void onSuccess(T response);

        void onFail(int code, String message);
    }

    public abstract void execute(R request);

    public void setCallBack(UseCaseCallBack<T> callBack) {
        this.callBack = callBack;
    }

    public UseCaseCallBack<T> getCallBack() {
        return callBack;
    }
}
