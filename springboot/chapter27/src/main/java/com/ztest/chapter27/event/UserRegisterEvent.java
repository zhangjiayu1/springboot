package com.ztest.chapter27.event;

import com.ztest.chapter27.bean.UserBean;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 11568
 * \* @date: 2019/08/28
 * \* Time: 14:58
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Getter
public class UserRegisterEvent extends ApplicationEvent {

    /**
     * 注册用户对象
     */
    private UserBean user;

    /**
     * 重写构造函数
     * @param source 发生事件的对象
     * @param user 注册用户对象
     */
    public UserRegisterEvent(Object source,UserBean user){
        super(source);
        this.user = user;
    }
}
