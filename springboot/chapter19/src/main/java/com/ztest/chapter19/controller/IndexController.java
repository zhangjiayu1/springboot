package com.ztest.chapter19.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/21
 * \* Time: 14:57
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@RestController
@RequestMapping(value = "api")
public class IndexController {

    @RequestMapping(value = "index")
    public String index(){
        return "success";
    }
}
