package com.ztest.chapter17.service;

import com.ztest.chapter17.entity.Users;
import com.ztest.chapter17.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/14
 * \* Time: 11:11
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 17
 * \
 */
public class UserService implements UserDetailsService {

    @Autowired
    UserJPA userJPA;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userJPA.findByUsername(username);
        if(null == users){
            throw new UsernameNotFoundException("未查询到用户: " + username + "信息");
        }
        return users;
    }
}
