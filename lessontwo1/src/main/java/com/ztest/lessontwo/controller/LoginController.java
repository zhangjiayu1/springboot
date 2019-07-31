package com.ztest.lessontwo.controller;


import com.ztest.lessontwo.entity.User;
import com.ztest.lessontwo.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/07/31
 * \* Time: 10:32
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description: login拦截器跳转(chapter 6)
 * \
 */
@RestController
@RequestMapping(value = "/user")
public class LoginController {

    @Autowired
    private UserJPA userJPA;

    @GetMapping(value = "/login")
    public String login(User user, HttpServletRequest request)
    {
        //登录成功
        boolean flag = true;
        String result = "登录成功";
        //根据用户名查询用户是否存在
        Optional<User> userEntity = userJPA.findOne(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                criteriaQuery.where(criteriaBuilder.equal(root.get("name"), user.getName()));
                return null;
            }
        });
        //用户不存在
        if(userEntity == null){
            flag = false;
            result = "用户不存在，登录失败";}
        //密码错误
        else if(!userEntity.get().getPwd().equals(user.getPwd())){
            flag = false;
            result = "用户密码不相符，登录失败";
        }
        //登录成功
        if(flag){
            //将用户写入session
            request.getSession().setAttribute("_session_user",userEntity);
        }
        return result;
    }
}
