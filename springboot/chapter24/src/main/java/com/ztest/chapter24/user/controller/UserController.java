package com.ztest.chapter24.user.controller;

import com.ztest.chapter24.user.bean.UserBean;
import com.ztest.chapter24.user.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 11568
 * \* @date: 2019/08/26
 * \* Time: 17:43
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserJPA userJPA;

    /**
     * 查询所有用户列表
     * @return
     */
    @RequestMapping("/list")
    public List<UserBean> list(){
        return userJPA.findAll();
    }
}
