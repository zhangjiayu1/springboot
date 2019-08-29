package com.ztest.chapter28;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 11568
 * \* @date: 2019/08/29
 * \* Time: 16:38
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class HelloService {

    /**
     * 消息内容
     */
    private String msg;
    /**
     * 是否显示消息内容
     */
    private boolean show = true;

    public String sayHello(){
        return show ? "Hello," + msg : "Hidden";
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}
