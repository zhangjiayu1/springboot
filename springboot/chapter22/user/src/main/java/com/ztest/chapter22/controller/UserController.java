package com.ztest.chapter22.controller;

import com.ztest.chapter22.bean.UserBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 11568
 * \* @date: 2019/08/23
 * \* Time: 16:44
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Controller
public class UserController {

    @RequestMapping(value = "/user/index")
    public String index(HttpServletRequest request, UserBean user){

        //将name属性传入到user_index.jsp页面中展示
        request.setAttribute("name",user.getName());
        //跳转user_index.jsp页面
        return "user_index";
    }
}
