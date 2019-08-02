//package com.ztest;
//
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.alibaba.fastjson.support.config.FastJsonConfig;
//import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * \* Created with IntelliJ IDEA.
// * \* User: 11568
// * \* Date: 2019/07/30
// * \* Time: 15:32
// * \* 码云: https://gitee.com/SXQZ/springboot
// * \* To change this template use File | Settings | File Templates.
// * \* Description: fastjson(chapter 5)
// * \
// */
//@Configuration
//public class FastJsonConfiguration implements WebMvcConfigurer {
//
//    /**
//     * 修改自定义消息转换器
//     * @param converters 消息转换器列表
//     */
//    @Override
//    public void  configureMessageConverters(List<HttpMessageConverter<?>> converters){
//        //调用父类的配置
//        WebMvcConfigurer.super.configureMessageConverters(converters);
//        //创建fastJson消息转换器
//        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//        //创建配置类
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        //处理中文乱码
//        List<MediaType> fastMediaType = new ArrayList<>();
//        fastMediaType.add(MediaType.APPLICATION_JSON_UTF8);
//        fastConverter.setSupportedMediaTypes(fastMediaType);
//        //修改配置返回内容的过滤
//        fastJsonConfig.setSerializerFeatures(
//                SerializerFeature.DisableCircularReferenceDetect,
//                SerializerFeature.WriteNullStringAsEmpty,
//                SerializerFeature.WriteMapNullValue
//        );
//        fastConverter.setFastJsonConfig(fastJsonConfig);
//        //将fastjson添加到视图消息转换器列表内
//        converters.add(fastConverter);
//    }
//}
