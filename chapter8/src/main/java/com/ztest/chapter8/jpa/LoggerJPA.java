package com.ztest.chapter8.jpa;

import com.ztest.chapter8.entity.LoggerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/05
 * \* Time: 13:50
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 8 实现 SpringDataJPA接口  请求日志数据接口
 * \
 */
public interface LoggerJPA
        extends JpaRepository<LoggerEntity,Long> {
}
