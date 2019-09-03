package com.ztest.chapter35.controller;

import com.ztest.chapter35.bean.GoodInfos;
import com.ztest.chapter35.jpa.GoodInfoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 11568
 * \* @date: 2019/09/03
 * \* Time: 16:28
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 35 测试类在test包中，readme.md中有对应的介绍
 * \
 */
@RestController
public class TestController {

    /**
     * 商品基本信息数据接口
     */
    @Autowired
    private GoodInfoJPA goodInfoJPA;

    /**
     * 查询首页内容
     * @param name
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(String name){
        return "This is index page" + name;
    }

    /**
     * 查询全部商品
     * @return
     */
    @RequestMapping(value = "/all")
    public List<GoodInfos> selectAll(){
        return goodInfoJPA.findAll();
    }

    /**
     * 查询商品详情
     * @param goodId
     * @return
     */
    public GoodInfos selectOne(Integer goodId){
        return goodInfoJPA.findById(goodId).orElse(null);
    }
}
