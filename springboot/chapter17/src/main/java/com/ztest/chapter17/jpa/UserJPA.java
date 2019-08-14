package com.ztest.chapter17.jpa;

import com.ztest.chapter17.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/14
 * \* Time: 10:50
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public interface UserJPA extends JpaRepository<Users,Long>
{
    //使用SpringDataJPA方法定义查询
    public Users findByUsername(String uUsername);
}

