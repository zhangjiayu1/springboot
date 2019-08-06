package com.ztest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ztest.chapter8.entity.LoggerEntity;
import com.ztest.chapter8.jpa.LoggerJPA;
import com.ztest.chapter8.util.LoggerUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import sun.plugin2.message.Serializer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/05
 * \* Time: 14:20
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 8 拦截器设置
 * \
 */
public class LoggerInterceptor implements HandlerInterceptor {

    //请求开始时间标识
    private static final String LOGGER_SEND_TIME = "_send_time";
    //请求日志实体标识
    private static final String LOGGER_ENTITY = "_logger_entity";

    /**
     * 进入SpringMVCdeController之前开始记录日志实体
     * @param request 请求对象
     * @param response 响应对象
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //创建日志实体类
        LoggerEntity logger = new LoggerEntity();
        //获取请求sessionId
        String sessionId = request.getRequestedSessionId();
        //请求路径
        String url = request.getRequestURI();
        //获取请求参数信息
        String paramData = JSON.toJSONString(request.getParameterMap(),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue);
        //设置客户端ip
        logger.setAliClientIp(LoggerUtils.getClientIp(request));
        //设置请求方法
        logger.setAliMethod(request.getMethod());
        //设置请求类型(json|普通请求)
        logger.setAliType(LoggerUtils.getRequestType(request));
        //设置请求参数内容json字符串
        logger.setAliParamData(paramData);
        //设置请求地址
        logger.setAliUri(url);
        //设置sessionId
        logger.setAliSessionId(sessionId);
        //设置请求开始时间
        request.setAttribute(LOGGER_SEND_TIME,System.currentTimeMillis());
        //设置请求实体到request内，方便afterCompletion方法调用
        request.setAttribute(LOGGER_ENTITY,logger);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        //获取请求错误码
        int status = response.getStatus();
        //当前时间
        long currentTime = System.currentTimeMillis();
        //请求开始时间
        long time = Long.valueOf(request.getAttribute(LOGGER_SEND_TIME).toString());
        //获取本次请求日志实体
        LoggerEntity loggerEntity = (LoggerEntity) request.getAttribute(LOGGER_ENTITY);
        //设置请求时间差
        loggerEntity.setAliTimeConsuming(Integer.valueOf((currentTime - time)+""));
        //设置返回时间
        loggerEntity.setAliReturnTime(currentTime + "");
        //设置返回错误码
        loggerEntity.setAliHttpStatusCode(status);
        //设置返回值
        loggerEntity.setAliReturnData(JSON.toJSONString(request.getAttribute(LoggerUtils.LOGGER_RETURN),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue));
        //执行将日志写入数据库
        LoggerJPA loggerDAO = getDAO(LoggerJPA.class,request);
        loggerDAO.save(loggerEntity);
    }

    private <T> T getDAO(Class<T> clas,HttpServletRequest request){
        BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        return factory.getBean(clas);
    }
}
