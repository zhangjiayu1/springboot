package com.ztest.chapter27.bean;

import lombok.Data;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 11568
 * \* @date: 2019/08/28
 * \* Time: 14:56
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Data
public class UserBean {

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;
}
