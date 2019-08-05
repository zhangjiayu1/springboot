package com.ztest.chapter8.util;

import javax.servlet.http.HttpServletRequest;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/05
 * \* Time: 15:35
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 8
 * \
 */
public final class LoggerUtils {

    public static final String LOGGER_RETURN = "_logger_return";

    private LoggerUtils(){}

    /**
     * 获取客户端ip地址
     * @param request
     * @return
     */
    public static String getClientIp(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.trim() == "" || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.trim() == "" || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.trim() == "" || "unknown".equalsIgnoreCase(ip)){
            ip = request.getRemoteAddr();
        }

        //多个路由时，取第一个非unknown的ip
        final String[] arr = ip.split(",");
        for(final String str : arr){
            if(!"unknown".equalsIgnoreCase(str)){
                ip = str;
                break;
            }
        }
        return ip;
    }

    /**
     * 判断是否为ajax请求
     * @param request
     * @return
     */
    public static String getRequestType(HttpServletRequest request){
        return request.getHeader("X-Requested-With");
    }
}
