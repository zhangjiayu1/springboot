package com.ztest.chapter24;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 11568
 * \* @date: 2019/08/26
 * \* Time: 14:35
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 24 @Qualifier注解并且设置内容，是为了防止注入时冲突问题
 * \
 */
@Configuration
public class DataSourceConfigurer {

    /**
     * 用户数据源
     * @return
     */
    @Bean(name = "userDataSource")//装配该方法返回值为userDataSource管理Bean
    @Qualifier("userDataSource")//spring装配bean唯一标识
    @ConfigurationProperties(prefix = "spring.datasource.user")//application.yml文件内配置数据源的前缀
    public DataSource userDataSource(){
        return DataSourceBuilder.create().build();
    }

    /**
     * 书籍数据源
     * @return
     */
    @Bean(name = "bookDataSource")
    @Primary//配置该数据源为主数据源
    @Qualifier("bookDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.book")
    public DataSource bookDataSource(){
        return DataSourceBuilder.create().build();
    }
}
