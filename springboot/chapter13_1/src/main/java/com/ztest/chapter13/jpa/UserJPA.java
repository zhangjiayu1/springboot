package com.ztest.chapter13.jpa;

import com.ztest.chapter13.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/09
 * \* Time: 10:26
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 13 JPA实现接口
 * \
 */
@Transactional
public interface UserJPA extends JpaRepository<User,Long> {

    //查询年龄大于20的用户
    @Query(value = "select * from t_user where t_age > :age",nativeQuery = true)
    public List<User> nativeQuery(@Param(value = "age")int age);

    //根据用户名、密码删除一条数据
    @Modifying
    @Query(value = "delete from t_user where t_name = :name and t_pwd = :pwd",nativeQuery = true)
    public void deleteQuery(@Param(value = "name") String name,@Param(value = "pwd") String pwd);
}
