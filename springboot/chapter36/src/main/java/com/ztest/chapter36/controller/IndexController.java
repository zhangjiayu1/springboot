package com.ztest.chapter36.controller;

import com.alibaba.fastjson.JSON;
import com.ztest.chapter36.annotation.ParameterModel;
import com.ztest.chapter36.bean.StudentEntity;
import com.ztest.chapter36.bean.TeacherEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

@RestController
public class IndexController {

    @RequestMapping(value = "/submit")
    public String resolver(@ParameterModel TeacherEntity teacher, @ParameterModel StudentEntity student){

        return "教师名称:" + JSON.toJSON(teacher.getName()) + ",学生名称:" + student.getName() + ",学生年龄：" + student.getAge();
    }
}
