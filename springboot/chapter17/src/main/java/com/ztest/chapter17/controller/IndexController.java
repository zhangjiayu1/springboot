package com.ztest.chapter17.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/14
 * \* Time: 11:09
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

@RestController
public class IndexController {
    @RequestMapping(value = "/index",method = RequestMethod.POST)
    public String index(){
        System.out.println("测试请求进来了没");
        return "get index success";
    }
}
