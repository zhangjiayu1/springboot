package com.ztest.chapter9;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/06
 * \* Time: 14:16
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 9 添加自定义静态资源配置
 * \
 */

@Configuration
public class Chapter9Configuration extends WebMvcConfigurationSupport {

    //自定义静态资源文件路径
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/SXQ/resources/**").addResourceLocations("classpath:/static/images/");
    }
}
