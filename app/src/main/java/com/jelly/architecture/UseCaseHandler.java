package com.jelly.architecture;

import android.os.Handler;

import com.jelly.domian.UseCase;


public class UseCaseHandler {

    private static UseCaseHandler INSTANCE;

    protected static final Handler handler = new Handler();

    private UseCaseHandler() {

    }

    public static UseCaseHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UseCaseHandler();
        }
        return INSTANCE;
    }

    public <R, T> void execute(UseCase<R, T> useCase, R request, UseCase.UserCaseCallBack<T> callBack) {
        useCase.setCallBack(new UiCallBackWrapper<T>(callBack));
        useCase.execute(request);
    }

    private static final class UiCallBackWrapper<T> implements UseCase.UserCaseCallBack<T> {

        private final UseCase.UserCaseCallBack<T> callBack;

        private UiCallBackWrapper(UseCase.UserCaseCallBack<T> callBack) {
            this.callBack = callBack;
        }

        @Override
        public void onSuccess(final T response) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    callBack.onSuccess(response);
                }
            });
        }

        @Override
        public void onFail(final int code, final String message) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    callBack.onFail(code, message);
                }
            });
        }
    }

}
