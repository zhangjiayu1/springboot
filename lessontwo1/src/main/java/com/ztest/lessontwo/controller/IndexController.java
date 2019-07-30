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
public class IndexController {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String toIndex(){
        return "index";
    }
}
