package com.jelly.domian;

public abstract class UseCase<R,T> {

    private UserCaseCallBack<T> callBack;

    public interface UserCaseCallBack<T> {
        void onSuccess(T response);

        void onFail(int code, String message);
    }

    public abstract void execute(R request);

    public void setCallBack(UserCaseCallBack<T> callBack) {
        this.callBack = callBack;
    }

    public UserCaseCallBack<T> getCallBack() {
        return callBack;
    }
}
