package com.ztest.chapter21;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/23
 * \* Time: 14:42
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@RestController
public class IndexController {

    @RequestMapping(value = "/index/{number}")
    public String index(@PathVariable int number){
        System.out.println(20/number);
        return "get index page successfully";
    }
}
