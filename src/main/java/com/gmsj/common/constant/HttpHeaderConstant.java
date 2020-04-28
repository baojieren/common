package com.gmsj.common.constant;

/**
 * 自定义请求头参数
 *
 * @author baojieren
 * @date 2020/4/16 16:40
 */
public class HttpHeaderConstant {

    /**
     * token串的key
     */
    public static final String HEADER_AUTH = "Authorization";

    /**
     * 可以是 web,mini,app
     */
    public static final String HEADER_PLATFORM = "Platform";

    /**
     * token 前缀
     */
    public static final String HEADER_SCHEME = "Bearer";

    /**
     * 追踪链id
     */
    public static final String HEADER_TRACEID = "TraceId";

    /**
     * IP地址
     */
    public static final String HEADER_IP = "IP";

    /**
     * 用户基本信息
     */
    public static final String HEADER_USER_INFO = "UserInfo";

}
