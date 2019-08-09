package com.ztest.chapter13.jpa;

import com.ztest.chapter13.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/09
 * \* Time: 10:26
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 13 JPA实现接口
 * \
 */
public interface UserJPA extends JpaRepository<User,Long> {
}
