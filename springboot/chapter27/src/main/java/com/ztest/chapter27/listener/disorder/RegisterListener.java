package com.ztest.chapter27.listener.disorder;

import com.ztest.chapter27.bean.UserBean;
import com.ztest.chapter27.event.UserRegisterEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 11568
 * \* @date: 2019/08/28
 * \* Time: 17:10
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 27 原始方式实现用户注册监听 实现ApplicationListener接口
 * \
 */
//@Component
public class RegisterListener implements ApplicationListener<UserRegisterEvent> {

    /**
     * 实现监听
     * @param userRegisterEvent
     */
    @Override
    public void onApplicationEvent(UserRegisterEvent userRegisterEvent) {

        //获取注册用户对象
        UserBean user = userRegisterEvent.getUser();
        //输出
        System.out.println("注册信息，用户名："+user.getName()+"，密码："+user.getPassword());
    }
}
