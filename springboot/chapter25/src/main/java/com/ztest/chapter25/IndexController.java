package com.ztest.chapter25;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 11568
 * \* @date: 2019/08/27
 * \* Time: 10:29
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@RestController
@ResponseBody
public class IndexController
{

    @RequestMapping(value = "/cors")
    public String corsIndex(){
        return "this is cors info.";
    }
}
