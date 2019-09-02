package com.ztest.chapter32;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 11568
 * \* @date: 2019/09/02
 * \* Time: 14:55
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@RestController
public class TestController {

    @RequestMapping(value = "index")
    public String index(){
        System.out.println("开始");
        int n = 0;
        for(int i = 100;i < 1000; i++){
            if(i % 10 == 9){
                if(i % 9 == 8){
                    if(i % 8 == 7){
                        n++;
                        System.out.println("这个数字是" + i);
                    }
                }
            }
        }
        System.out.println("存在的个数为" + n);
        return "index";
    }
}
