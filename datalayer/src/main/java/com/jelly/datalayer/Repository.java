package com.jelly.datalayer;

import static com.jelly.tool.RequestMethod.REMOTE_ONLY;

public class Repository {
    /**
     * 操作方式
     */
    private int Method = REMOTE_ONLY;

    public void setMethod(int method) {
        Method = method;
    }

    public int getMethod() {
        return Method;
    }
}
