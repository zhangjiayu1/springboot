//package com.ztest;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.web.servlet.view.JstlView;
//import org.springframework.web.servlet.view.UrlBasedViewResolver;
//
///**
// * \* Created with IntelliJ IDEA.
// * \* User: 11568
// * \* Date: 2019/07/31
// * \* Time: 15:20
// * \* 码云: https://gitee.com/SXQZ/springboot
// * \* To change this template use File | Settings | File Templates.
// * \* Description: 在配置拦截器的时候fastjson配置messageConver时会影响到拦截器
// * \*所以就加了这个方法
// * \
// */
//
//@Configuration
////@ConfigurationProperties(prefix="spring.mvc.view")
//@PropertySource("classpath:application.properties")
//public class DefaultConfiguration {
//
////    private String prefix;
////    private String suffix;
////
////    public String getPrefix() {
////        return prefix;
////    }
////
////    public void setPrefix(String prefix) {
////        this.prefix = prefix;
////    }
////
////    public String getSuffix() {
////        return suffix;
////    }
////
////    public void setSuffix(String suffix) {
////        this.suffix = suffix;
////    }
////
////    @Bean
////    public UrlBasedViewResolver setupViewResolver(){
////        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
////        resolver.setPrefix(prefix);
////        resolver.setSuffix(suffix);
////        resolver.setCache(true);
////        resolver.setViewClass(JstlView.class);
////        return resolver;
////    }
//}
