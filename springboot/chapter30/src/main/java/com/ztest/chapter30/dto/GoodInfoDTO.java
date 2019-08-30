package com.ztest.chapter30.dto;

import lombok.Data;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 11568
 * \* @date: 2019/08/30
 * \* Time: 15:19
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Data
public class GoodInfoDTO {

    /**
     * 商品编号
     */
    private String goodId;
    /**
     * 商品名称
     */
    private String goodName;
    /**
     * 商品价格
     */
    private Double goodPrice;
    /**
     * 类型名称
     */
    private String typeName;
}
