package com.ztest.chapter18.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/19
 * \* Time: 17:10
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 18 获取授权Token才可以访问到
 * \
 */

@RestController
@RequestMapping("/secure")
public class SecureController {

    @GetMapping
    public String sayHello(){
        return "Secure Hello!";
    }
}
