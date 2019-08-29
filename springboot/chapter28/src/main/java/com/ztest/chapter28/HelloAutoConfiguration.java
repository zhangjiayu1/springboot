package com.ztest.chapter28;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 11568
 * \* @date: 2019/08/29
 * \* Time: 16:43
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 28 自定义starter自动化配置
 * \
 */
@Configuration//开启配置
@EnableConfigurationProperties(HelloProperties.class)//开启使用映射实体对象
@ConditionalOnClass(HelloService.class)//存在HelloService时初始化该配置类
@ConditionalOnProperty(//存在对应配置信息时初始化该配置类
        prefix = "hello",//存在配置前缀hello
        value = "enabled",//开启
        matchIfMissing = true//缺失检查
)
public class HelloAutoConfiguration {

    /**
     * application.properties配置文件映射前缀实体对象
     */
    @Autowired
    private HelloProperties helloProperties;

    @Bean//创建HelloService实体Bean
    @ConditionalOnMissingBean(HelloService.class)//缺失HelloService实体Bean时，初始化HelloService并添加到SpringIoc
    public HelloService helloService(){
        System.out.println(">>>The HelloService Not Found，Execute Create New Bean.");
        HelloService helloService = new HelloService();
        //设置消息内容
        helloService.setMsg(helloProperties.getMsg());
        //设置是否显示
        helloService.setShow(helloProperties.isShow());
        return helloService;
    }
}
