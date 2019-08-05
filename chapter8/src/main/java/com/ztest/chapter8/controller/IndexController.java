package com.ztest.chapter8.controller;

import com.alibaba.fastjson.JSONObject;
import com.ztest.chapter8.util.LoggerUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/05
 * \* Time: 15:35
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this templ ate use File | Settings | File Templates.
 * \* Description:chapter 8
 * \
 */

@RestController
@RequestMapping(value = "/index")
public class IndexController {

    /**
     * 简单测试请求日志的记录
     * @param request
     * @param name
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/login")
    public JSONObject login(HttpServletRequest request,String name) throws Exception{
        JSONObject obj = new JSONObject();
        obj.put("msg","用户："+name+",登录成功。");
        //将返回值写入到请求对象中
        request.setAttribute(LoggerUtils.LOGGER_RETURN,obj);
        return obj;
    }
}
