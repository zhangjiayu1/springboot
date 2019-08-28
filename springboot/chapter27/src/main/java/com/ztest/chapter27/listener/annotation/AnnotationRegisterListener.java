package com.ztest.chapter27.listener.annotation;

import com.ztest.chapter27.bean.UserBean;
import com.ztest.chapter27.event.UserRegisterEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 11568
 * \* @date: 2019/08/28
 * \* Time: 16:19
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 27 使用@EventListener方法实现注册事件监听
 * \
 */
//@Component
public class AnnotationRegisterListener {

    /**
     * 注册监听实现方法
     * @param userRegisterEvent 用户注册事件
     */
    @EventListener
    public void register(UserRegisterEvent userRegisterEvent){

        //获取注册用户对象
        UserBean user = userRegisterEvent.getUser();
        //输出
        System.out.println("@EventListener注册信息，用户名: "+ user.getName() + ",密码："+ user.getPassword());
    }
}
