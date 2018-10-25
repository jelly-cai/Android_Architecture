package com.jelly.tool;

public class RequestMethod {
    /**
     * 直接请求远程数据
     */
    public static final int REMOTE_ONLY = 1;
    /**
     * 有本地数据取本地数据，没有本地数据就去取远程数据并且缓存远程数据
     */
    public static final int LOCAL_REMOTE_CACHE = 2;
    /**
     * 仅仅请求本地数据
     */
    public static final int LOCAL_ONLY = 3;
}
