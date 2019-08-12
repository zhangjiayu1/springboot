package com.ztest.chapter14.jpa;

import com.ztest.chapter14.entity.GoodInfos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/12
 * \* Time: 10:41
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public interface GoodJPA
        extends JpaRepository<GoodInfos,Long>,
        QuerydslPredicateExecutor<GoodInfos> {
}
