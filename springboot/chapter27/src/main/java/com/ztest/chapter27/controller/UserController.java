package com.ztest.chapter27.controller;

import com.ztest.chapter27.bean.UserBean;
import com.ztest.chapter27.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 11568
 * \* @date: 2019/08/28
 * \* Time: 15:22
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@RestController
public class UserController {

    /**
     * 用户业务逻辑实现
     */
    @Autowired
    private UserService userService;

    /**
     * 注册控制方法
     * @param user 用户对象
     * @return
     */
    @RequestMapping(value = "/register")
    public String register(UserBean user){
        //调用注册业务逻辑
        userService.register(user);
        return "注册成功";
    }
}
