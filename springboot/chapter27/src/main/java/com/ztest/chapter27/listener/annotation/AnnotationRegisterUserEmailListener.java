package com.ztest.chapter27.listener.annotation;

import com.ztest.chapter27.event.UserRegisterEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 11568
 * \* @date: 2019/08/28
 * \* Time: 17:20
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 27 注册用户事件发送邮件监听
 * \
 */
//@Component
public class AnnotationRegisterUserEmailListener {

    /**
     * 发送邮件监听实现
     * @param userRegisterEvent 用户注册事件
     */
    @EventListener
    public void sendMail(UserRegisterEvent userRegisterEvent){
        System.out.println("用户注册成功，发送邮件。");
    }
}
