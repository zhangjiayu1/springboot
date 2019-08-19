package com.ztest.chapter18.jpa;

import com.ztest.chapter18.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/19
 * \* Time: 17:00
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 18 自定义查询，HQL语法构建语句，根据用户名不区分大小写查询
 * \
 */
public interface UserJPA extends JpaRepository<User,String> {

    @Query("select u from User u where lower(u.username) = lower(:username) ")
    User findByUsernameCaseInsensitive(@Param("username") String username);
}
