package com.ztest.chapter24.base.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 11568
 * \* @date: 2019/08/26
 * \* Time: 17:36
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 24
 * \* 该接口继承自JpaRepository<T, Long>,如需自定义CRUD函数，可自己在继承该接口的子接口内实现
 */
public interface BaseDAO<T> extends JpaRepository<T,Long>, JpaSpecificationExecutor<T>, Serializable {
}
