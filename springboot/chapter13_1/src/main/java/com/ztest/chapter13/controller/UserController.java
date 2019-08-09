package com.ztest.chapter13.controller;

import com.ztest.chapter13.entity.User;
import com.ztest.chapter13.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/09
 * \* Time: 10:40
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 13 控制实现类
 * \
 */
@RestController
public class UserController {

    @Autowired
    private UserJPA userJPA;

    @RequestMapping(value = "/list")
    public List<User> list(){
        return userJPA.findAll();
    }

    @RequestMapping(value = "/add")
    public String add(){
        User user = new User();
        user.setTName("测试");
        user.setTAddress("测试地址");
        user.setTAge(21);
        userJPA.save(user);
        return "用户信息添加成功";
    }
}
