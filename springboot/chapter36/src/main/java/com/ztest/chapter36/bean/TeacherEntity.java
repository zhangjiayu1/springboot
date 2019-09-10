package com.ztest.chapter36.bean;

import lombok.Data;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 11568
 * \* @date: 2019/09/10
 * \* Time: 14:25
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

@Data
public class TeacherEntity {

    /**
     * 教师姓名
     */
    private List<String> name;
}
