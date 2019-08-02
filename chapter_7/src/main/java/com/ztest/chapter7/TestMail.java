package com.ztest.chapter7;

import com.ztest.chapter7.core.MailSender;
import com.ztest.chapter7.enums.MailContentTypeEnum;

import java.util.ArrayList;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/02
 * \* Time: 17:37
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:邮件执行类
 * \
 */
public class TestMail {
    public static void main(String[] args) throws Exception{
        new MailSender()
                .title("测试SpringBoot发送邮件")
                .content("简单文本内容发送")
                .contentType(MailContentTypeEnum.TEXT)
                .targets(new ArrayList<String>(){{
                    add("13439668817@163.com");
                }})
                .send();
    }
}
