package com.ztest.chapter24;

import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;
import java.util.Properties;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 11568
 * \* @date: 2019/08/26
 * \* Time: 14:56
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryBook",//实体管理引用
        transactionManagerRef = "transactionManagerBook",//事务管理引用
        basePackages = { "com.ztest.chapter24.book" }//设置书籍数据源所应用到的包
)
public class BookDataSourceConfigurer {

    /**
     * 注入书籍数据源
     */
    @Autowired
    @Qualifier("bookDataSource")
    private DataSource bookDataSource;

    /**
     * 注入jpa配置实体
     */
    @Resource
    private Properties jpaProperties;

    /**
     * 配置EntityManager实体
     */
    @Primary
    @Bean(name = "entityManagerBook")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder){
        return entityManagerFactoryBook(builder).getObject().createEntityManager();
    }

    /**
     * 配置EntityManager工厂实体
     * @param builder
     * @return
     */
    @Primary
    @Bean(name = "entityManagerFactoryBook")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBook(EntityManagerFactoryBuilder builder){
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = builder
                .dataSource(bookDataSource)
                .packages(new String[]{ "com.ztest.chapter24.book" })
                .persistenceUnit("bookPersistenceUnit")
                .build();
        entityManagerFactoryBean.setJpaProperties(jpaProperties);
        return entityManagerFactoryBean;
    }

    /**
     * 配置事务
     * @param builder
     * @return
     */
    @Primary
    @Bean(name = "transactionManagerBook")
    public PlatformTransactionManager transactionManagerBook(EntityManagerFactoryBuilder builder){
        return new JpaTransactionManager(entityManagerFactoryBook(builder).getObject());
    }
}
