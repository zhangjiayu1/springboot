package com.ztest.chapter21;

import org.springframework.web.bind.annotation.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/23
 * \* Time: 14:15
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 21
 * \* @ControllerAdvice注解是用来配置控制器通知的，我们可以配置过滤拦截具体一种或者多种类型的注解，添加annotations属性即可
 * \* @ExceptionHandler注解用来配置需要拦截的异常类型，默认是全局类型。
 * \* @ResponseStatus注解用于配置遇到该异常后返回数据时的StatusCode的值，我们这里默认使用值500
 */
@ControllerAdvice(annotations = RestController.class)
@ResponseBody
public class RestExceptionHandler {

    /**
     * 默认统一异常处理方法
     * @param e
     * @return
     */
    @ExceptionHandler
    @ResponseStatus
    public ApiResult rentimeExceptionHandler(Exception e){
        return ApiResultGenerator.errorResult(e.getMessage(),e);
    }
}
