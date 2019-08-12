package com.ztest.chapter14.controller;

import com.querydsl.jpa.impl.JPAQuery;
import com.ztest.chapter14.Inquirer;
import com.ztest.chapter14.entity.GoodInfos;
import com.ztest.chapter14.entity.QGoodInfos;
import com.ztest.chapter14.jpa.GoodJPA;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/12
 * \* Time: 10:37
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 14 querydsl查询功能
 * \
 */
@RestController
public class QueryController {
    @Autowired
    private GoodJPA goodJPA;

    //注入EntityManager
    @PersistenceContext
    private EntityManager entityManager;

    @RequestMapping(value = "/query")
    public List<GoodInfos> list(){
        //querysdl查询实体
        QGoodInfos _good = QGoodInfos.goodInfos;
        //构建JPA查询对象
        JPAQuery<GoodInfos> jpaQuery = new JPAQuery<>(entityManager);
        //返回查询接口
        return jpaQuery
                //查询字段
                .select(_good)
                //查询表
                .from(_good)
                //查询条件
                .where(_good.type.tgtId.eq(Long.valueOf("1")))
                //返回结果
                .fetch();
    }

    @RequestMapping(value = "/join")
    public List<GoodInfos> join(){
        //querydsl查询实体
        QGoodInfos _good = QGoodInfos.goodInfos;
        //自定义查询对象
        Inquirer inquirer = new Inquirer();
        //添加查询条件
        inquirer.putExpression(_good.type.tgtId.eq(Long.valueOf("1")));
        //返回查询结果
        return inquirer.iteratorToList(goodJPA.findAll(inquirer.buildQuery()));
    }
}
