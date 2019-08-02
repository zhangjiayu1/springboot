package com.ztest.chapter7.enums;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/02
 * \* Time: 11:00
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:自定义枚举类 定义邮件内容类型 目前 html text
 * \
 */
public enum MailContentTypeEnum {
    HTML("text/html;charset=UTF-8"), //html格式
    TEXT("text")
    ;
    private String value;

    MailContentTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
