package com.ztest.chapter20;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/22
 * \* Time: 17:28
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 20
 * \* 当浏览器向服务端发送请求时，通过@MessageMapping映射/welcome这个地址，类似@RequestMapping
 * \* 当服务端有消息存在时，会对订阅@SendTo中路径的浏览器发送请求
 * \
 */
@Controller
public class WsController {
    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public WiselyResponse say(WiselyMessage message) throws Exception{
        //等待3秒返回消息内容
        Thread.sleep(3000);
        return new WiselyResponse("欢迎使用webSocket:"+message.getName());
    }
}
