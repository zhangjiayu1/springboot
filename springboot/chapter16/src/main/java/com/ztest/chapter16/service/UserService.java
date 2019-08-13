package com.ztest.chapter16.service;

import com.ztest.chapter16.entity.User;
import com.ztest.chapter16.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/13
 * \* Time: 15:00
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 16
 * \*
 * \*
 * \* @CacheConfig：该注解是用来开启声明的类参与缓存,如果方法内的@Cacheable注解没有添加key值，那么会自动使用cahceNames配置参数并且追加方法名。
 * \* @Cacheable：配置方法的缓存参数，可自定义缓存的key以及value。
 * \*
 */
@Service
@CacheConfig(cacheNames = "user")
public class UserService {

    @Autowired
    private UserJPA userJPA;

    @Cacheable
    public List<User> list(){
        return userJPA.findAll();
    }
}
