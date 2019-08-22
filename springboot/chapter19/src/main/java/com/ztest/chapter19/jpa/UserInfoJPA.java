package com.ztest.chapter19.jpa;

import com.ztest.chapter19.entity.ApiUserInfos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/21
 * \* Time: 14:50
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public interface UserInfoJPA extends JpaRepository<ApiUserInfos,Long>,
        JpaSpecificationExecutor<ApiUserInfos> {
    public ApiUserInfos findByAppId(String appId);
}
