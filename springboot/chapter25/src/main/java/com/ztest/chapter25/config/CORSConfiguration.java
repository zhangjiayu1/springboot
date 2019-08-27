package com.ztest.chapter25.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 11568
 * \* @date: 2019/08/27
 * \* Time: 10:29
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Configuration
public class CORSConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                //配置可以被跨域的路径，可具体到直接请求路径
                .addMapping("/**")
                //允许所有请求方法放蚊该跨域资源服务器，也可设置固定某个
                .allowedMethods("*")
                //允许所有的请求域名访问跨域资源，也可固定单挑或者多条
                .allowedOrigins("*")
                //允许所有的请求header访问，可以自定义设置任意请求头信息
                .allowedHeaders("*");
    }
}
