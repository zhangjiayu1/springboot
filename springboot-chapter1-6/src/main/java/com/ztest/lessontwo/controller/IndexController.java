package com.ztest.lessontwo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Author:shuangxuqi
 * Date:2019-07-29
 * Time:17:25
 * Content:jsp跳转(第二章)
 */
@Controller
@RequestMapping(value = "/user")
public class IndexController {
    /**
     * 初始化登录页面
     * @return
     */
    @RequestMapping(value = "/login_view",method = RequestMethod.GET)
    public String login_view(){
        return "login";
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
