package com.ztest.chapter37.resovler;

import com.ztest.chapter37.annotation.ContentSecurityAttribute;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 11568
 * \* @date: 2019/09/17
 * \* Time: 16:16
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 37
 * \* 自定义方法参数映射
 * \* 实现了HandlerMethodArgumentResolver接口内的方法supportsParameter & resolveArgument
 * \* 通过supportsParameter方法判断仅存在@ContentSecurityAttribute注解的参数才会执行resolverArgument方法实现
 * \
 */

public class ContentSecurityMethodArgumentResolver extends BaseMethodArgumentResolver{

    private Logger logger = LoggerFactory.getLogger(ContentSecurityMethodArgumentResolver.class);

    /**
     * 判断参数是否配置了@ContentSecurityAttribute注解
     * 如果返回true则执行resolveArgument方法
     * @param methodParameter
     * @return
     */
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(ContentSecurityAttribute.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        return null;
    }
}
