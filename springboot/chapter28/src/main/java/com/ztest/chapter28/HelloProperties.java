package com.ztest.chapter28;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 11568
 * \* @date: 2019/08/29
 * \* Time: 16:14
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 28 配置文件实体映射
 * \* @ConfigurationProperties注解内我们使用到了属性preffix，该属性配置了读取参数的前缀，根据上面的实体属性对应配置文件内的配置则是hello.msg、hello.show
 */
@ConfigurationProperties(prefix = "hello")
public class HelloProperties {

    /**
     * 消息内容
     */
    private String msg = "SXQZ";

    /**
     * 是否显示消息内容
     */
    private boolean show = true;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}
