package com.ztest.chapter18;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/20
 * \* Time: 09:30
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 18 自定义异常
 * \
 */
public class NewUserNotFoundException extends RuntimeException {

    public NewUserNotFoundException(String msg,Throwable t) {
        super(msg,t);
    }

    public NewUserNotFoundException(String msg){
        super(msg);
    }
}
