package com.ztest.chapter19;

import org.apache.commons.lang3.StringUtils;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import io.jsonwebtoken.SignatureException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/21
 * \* Time: 16:35
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 19 获取token的路径排除在外拦截所有的路径，验证路径是否存在header包含token，并且验证token是否正确
 * \
 */
public class JwtTokenInterceptor implements HandlerInterceptor {

    /**
     * 请求之前拦截处理
     * @param request 请求对象
     * @param response 返回对象
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        //自动排除生成token的路径，并且如果是options请求是cors跨域预请求，设置allow对应头信息
        if(request.getRequestURI().equals("/token") || RequestMethod.OPTIONS.toString().equals(request.getMethod())){
            return true;
        }
        //其他请求获取头信息
        final String authHeader = request.getHeader("X-YAuth-Token");
        try {
            //如果没有header信息
            if(StringUtils.isBlank(authHeader)){
                throw new SignatureException("not found X-YAuth-Token");
            }
        }catch (SignatureException | ExpiredJwtException e){

        }
        return false;
    }
}
