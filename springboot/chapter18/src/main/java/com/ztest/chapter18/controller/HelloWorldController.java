package com.ztest.chapter18.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/19
 * \* Time: 17:07
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 18 开放此控制器，不让SpringSecurity管理
 * \
 */
@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(){
        return "Hello User!";
    }
}
