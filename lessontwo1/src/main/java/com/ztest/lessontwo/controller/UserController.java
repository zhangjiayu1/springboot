package com.ztest.lessontwo.controller;


import com.ztest.lessontwo.entity.User;
import com.ztest.lessontwo.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Author:shuangxuqi
 * Date:2019-07-29
 * Time:18:17
 * Content:配合jpa数据库操作(第三章)
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserJPA userJPA;

    /**
     * 查询
     */
    @GetMapping(value = "/list")
    public List<User> list(){
        return userJPA.findAll();
    }

    /**
     * 添加更新
     * jpa.save() 既可以添加也可以更新 存在主键则更新，没有就添加
     */
    @GetMapping(value = "/save")
    public User save(User user){
        return userJPA.save(user);
    }


    /**
     * 删除
     */
    @GetMapping(value = "/delete")
    public List<User> delete(Long id){
        userJPA.deleteById(id);
        return userJPA.findAll();
    }

}
