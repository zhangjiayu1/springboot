package com.ztest.chapter16.jpa;

import com.ztest.chapter16.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/13
 * \* Time: 14:59
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public interface UserJPA extends JpaRepository<User,Long> {
}
