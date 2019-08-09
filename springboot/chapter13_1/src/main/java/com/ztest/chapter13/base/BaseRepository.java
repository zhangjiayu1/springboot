package com.ztest.chapter13.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/09
 * \* Time: 14:07
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@NoRepositoryBean
public interface BaseRepository <T,PK extends Serializable> extends JpaRepository<T,PK> {
}
