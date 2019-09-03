package com.ztest.chapter35.jpa;

import com.ztest.chapter35.bean.GoodInfos;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 11568
 * \* @date: 2019/09/03
 * \* Time: 16:25
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public interface GoodInfoJPA extends JpaRepository<GoodInfos,Integer> {
}
