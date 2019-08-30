package com.ztest.chapter30.jpa;

import com.ztest.chapter30.bean.GoodInfos;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 11568
 * \* @date: 2019/08/30
 * \* Time: 15:18
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public interface GoodInfoJPA
        extends JpaRepository<GoodInfos,Long>
{

}