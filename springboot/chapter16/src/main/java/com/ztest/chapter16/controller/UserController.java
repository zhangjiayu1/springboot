package com.ztest.chapter16.controller;

import com.ztest.chapter16.entity.User;
import com.ztest.chapter16.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/13
 * \* Time: 15:08
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询用户列表
     * @return
     */
    @RequestMapping(value = "/list")
    public List<User> list(){
        return userService.list();
    }
}
