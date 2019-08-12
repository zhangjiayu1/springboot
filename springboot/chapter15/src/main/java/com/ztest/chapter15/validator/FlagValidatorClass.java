package com.ztest.chapter15.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/12
 * \* Time: 17:36
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 15 自定义注解的验证实现类
 * \
 */
public class FlagValidatorClass implements ConstraintValidator<FlagValidator,Object> {

    //临时变量保存flag值列表
    private String values;

    //初始化values的值
    @Override
    public void initialize(FlagValidator flagValidator) {
        //将注解内配置的值赋值给临时变量
        this.values = flagValidator.values();
    }

    //实现验证
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        //分割定义的有效值
        String[] value_array = values.split(",");
        boolean isFlag = false;
        //遍历对比有效值
        for (int i = 0;i < value_array.length;i++){
            //存在一致跳出循环，赋值isFlag=true
            if(value_array[i].equals(value)){
                isFlag = true;
                break;
            }
        }
        //返回是否存在boolean
        return isFlag;
    }
}
