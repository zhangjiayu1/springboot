package com.ztest.chapter16;

import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Method;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/13
 * \* Time: 14:36
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 16 redis配置类
 * \
 */
@Configuration
@EnableCaching
public class RedisConfiguration extends CachingConfigurerSupport {

    /**
     * 自定义生成key的规则
     * @return
     */
    @Override
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                //格式化缓存key字符串
                StringBuilder sb = new StringBuilder();
                //追加类名
                sb.append(o.getClass().getName());
                //追加方法名
                sb.append(method.getName());
                //遍历参数并且追加
                for(Object obj : objects){
                    sb.append(obj.toString());
                }
                System.out.println("调用Redis缓存key:"+sb.toString());
                return sb.toString();
            }
        };
    }

    /**
     * 采用RedisCacheManager作为缓存管理器
     * @param redisTemplate
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisTemplate){
        return RedisCacheManager.create(redisTemplate);
    }
}
