package com.ztest.chapter15.entity;

import com.ztest.chapter15.validator.FlagValidator;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/12
 * \* Time: 16:03
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 15 hibernate-validator注解校验
 * \
 */
public class DemoEntity implements Serializable {

    @NotBlank
    @Length(min = 2,max = 10)
    private String name;

    @Min(value = 1)
    private int age;

    @NotBlank
    @Email
    private String mail;

    @FlagValidator(values = "1,2,3")
    private String flag;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
