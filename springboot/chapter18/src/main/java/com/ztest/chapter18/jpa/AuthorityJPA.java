package com.ztest.chapter18.jpa;

import com.ztest.chapter18.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/19
 * \* Time: 17:00
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public interface AuthorityJPA extends JpaRepository<Authority,String> {
}
