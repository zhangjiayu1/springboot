package com.ztest.chapter27.service;

import com.ztest.chapter27.bean.UserBean;
import com.ztest.chapter27.event.UserRegisterEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 11568
 * \* @date: 2019/08/28
 * \* Time: 15:07
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Service
public class UserService {

    @Autowired
    ApplicationContext applicationContext;

    /**
     * 发布UserRegisterEvent事件
     * @param user
     */
    public void register(UserBean user){
        applicationContext.publishEvent(new UserRegisterEvent(this,user));
    }
}
