package com.ztest.chapter17;

import com.ztest.chapter17.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/14
 * \* Time: 11:10
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 17 SpringBoot2.0 之后对要求用户保存的密码必须要使用加密算法后存储，在登录验证的时候Security会将获得的密码在进行编码后再和数据库中加密后的密码进行对比，
 * \*                        所以必须要重写configure(AuthenticationManagerBuilder auth)来指定密码的加密规则
 * \                         https://blog.csdn.net/zhangjiayu024/article/details/99586380
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //完成自定义实体注入
    @Bean
    UserDetailsService userService(){
        return new UserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService()).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                //所有请求必须登录后访问
                .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .failureUrl("/login?error")
                    //登录界面，错误界面可以直接访问
                    .permitAll()
                .and()
                .logout()
                .permitAll();//注销请求可直接访问
    }
}
