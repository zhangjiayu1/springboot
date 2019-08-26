package com.ztest.chapter24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
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
import java.util.Properties;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 11568
 * \* @date: 2019/08/26
 * \* Time: 14:55
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryUser",//实体管理引用
        transactionManagerRef = "transactionManagerUser",//事务管理引用
        basePackages = { "com.ztest.chapter24.user" }//设置书籍数据源所应用到的包
)
public class UserDataSourceConfigurer {

    /**
     * 注入书籍数据源
     */
    @Autowired
    @Qualifier("userDataSource")
    private DataSource userDataSource;

    /**
     * 注入jpa配置实体
     */
    @Resource
    private Properties jpaProperties;

    /**
     * 配置EntityManager实体
     */
    @Primary
    @Bean(name = "entityManagerUser")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder){
        return entityManagerFactoryUser(builder).getObject().createEntityManager();
    }

    /**
     * 配置EntityManager工厂实体
     * @param builder
     * @return
     */
    @Bean(name = "entityManagerFactoryUser")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryUser(EntityManagerFactoryBuilder builder){
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = builder
                .dataSource(userDataSource)
                .packages(new String[]{ "com.ztest.chapter24.user" })
                .persistenceUnit("userPersistenceUnit")
                .build();
        entityManagerFactoryBean.setJpaProperties(jpaProperties);
        return entityManagerFactoryBean;
    }

    /**
     * 配置事务
     * @param builder
     * @return
     */
    @Bean(name = "transactionManagerUser")
    public PlatformTransactionManager transactionManagerUser(EntityManagerFactoryBuilder builder){
        return new JpaTransactionManager(entityManagerFactoryUser(builder).getObject());
    }
}
