package com.ztest.chapter30.controller;

import com.ztest.chapter30.bean.GoodInfos;
import com.ztest.chapter30.bean.GoodTypes;
import com.ztest.chapter30.dto.GoodInfoDTO;
import com.ztest.chapter30.jpa.GoodInfoJPA;
import com.ztest.chapter30.jpa.GoodTypeJPA;
import com.ztest.chapter30.mapper.GoodInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 11568
 * \* @date: 2019/08/30
 * \* Time: 16:02
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@RestController
public class GoodInfoController {

    /**
     * 注入商品基本信息jpa
     */
    @Autowired
    private GoodInfoJPA goodInfoJPA;

    /**
     * 注入商品类型jpa
     */
    @Autowired
    private GoodTypeJPA goodTypeJPA;

    /**
     * 注入mapStruct转换Mapper
     */
    @Autowired
    private GoodInfoMapper goodInfoMapper;

    /**
     * 查询商品详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/detail/{tgId}")
    public GoodInfoDTO detail(@PathVariable("tgId") Long id){
        //查询商品基本信息
        GoodInfos goodInfos = goodInfoJPA.findById(id).orElse(null);
        //查询商品类型基本信息
        GoodTypes goodTypes = goodTypeJPA.findById(goodInfos.getTgTypeId()).orElse(null);
        //返回转换dto
        return goodInfoMapper.from(goodInfos,goodTypes);
    }
}
