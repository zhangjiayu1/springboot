package com.ztest.chapter19.controller;

import com.ztest.chapter19.TokenResult;
import com.ztest.chapter19.entity.ApiTokenInfos;
import com.ztest.chapter19.entity.ApiUserInfos;
import com.ztest.chapter19.jpa.TokenJPA;
import com.ztest.chapter19.jpa.UserInfoJPA;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/21
 * \* Time: 14:56
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 19 token生成
 * \* getOne返回的Optional是Java8中一个可以为null的容器对象，调用.get()方法没有值的话会抛出NoSuchElemwntException异常 所以下文中用getAll().get(0)
 * \* 获取用户实体与token地方换成了自定义的JPA方法，以免抛出异常
 */
@RestController
@RequestMapping(value = "/jwt")
public class TokenController {

    @Autowired
    private TokenJPA tokenJPA;

    @Autowired
    private UserInfoJPA userInfoJPA;

    /**
     * 获取token，更新token
     * @param appId 用户编号
     * @param appSecret 用户密码
     * @return
     */
    @RequestMapping(value = "/token",method = {RequestMethod.GET,RequestMethod.POST})
    public TokenResult token(@RequestParam String appId,@RequestParam String appSecret){

        TokenResult token = new TokenResult();
        //appId is null
        if(appId == null || appId.trim() == ""){
            token.setFlag(false);
            token.setMsg("appId is not found!");
        }//appSecret is null
        else if(appSecret == null || appSecret.trim() == ""){
            token.setFlag(false);
            token.setMsg("appSecret is not found!");
        }else{
            //根据appId查询用户实体
            ApiUserInfos userDbInfo = userInfoJPA.findByAppId(appId);
            //如果不存在的话
            if(userDbInfo == null){
                token.setFlag(false);
                token.setMsg("appId : " + appId + ", is not found");
            }
            //验证appSecret是否存在
            else if(!new String(userDbInfo.getAppSecret()).equals(appSecret.replace(" ","+"))){
                token.setFlag(false);
                token.setMsg("appSecret is not effective");
            }else{
                //检测数据库是否存在该appId的token值
                ApiTokenInfos tokenDBEntity = tokenJPA.findByAppId(appId);
                //返回token值
                String tokenStr = null;
                //tokenDBEntity == null -> 生成newTOken -> 保存数据库 -> 写入内存 -> 返回newToken
                if(tokenDBEntity == null){
                    //生成jwt，Token
                    tokenStr = createNewToken(appId);
                    //将token保存到数据库
                    tokenDBEntity = new ApiTokenInfos();
                    tokenDBEntity.setAppId(userDbInfo.getAppId());
                    tokenDBEntity.setAtiBuildTime(String.valueOf(System.currentTimeMillis()));
                    tokenDBEntity.setAtiToken(tokenStr.getBytes());
                    tokenJPA.save(tokenDBEntity);
                }
                //tokenDBEntity != null -> 验证是否超时
                //不超时 -> 直接返回dbToken
                //超时 -> 生成newToken -> 更新dbToken -> 更新内存Token -> 返回呢哇Token
                else{
                    //判断数据库中token是否过期，如果没有过期不需要更新直接返回数据库中的token即可
                    //数据库中更新时间
                    long dbBuildTime = Long.valueOf(tokenDBEntity.getAtiBuildTime());
                    //当前时间
                    long currentTime = System.currentTimeMillis();
                    //如果当前时间 - 数据库中生成时间 < 7200 证明可以正常使用
                    long second = TimeUnit.MILLISECONDS.toSeconds(currentTime - dbBuildTime);
                    if(second > 0 && second < 7200){
                        tokenStr = new String(tokenDBEntity.getAtiToken());
                    }
                    //超时
                    else {
                        //生成newToken
                        tokenStr = createNewToken(appId);
                        //更新token
                        tokenDBEntity.setAtiToken(tokenStr.getBytes());
                        //更新生成时间
                        tokenDBEntity.setAtiBuildTime(String.valueOf(System.currentTimeMillis()));
                        //执行更新
                        tokenJPA.save(tokenDBEntity);
                    }
                }
                //设置返回token
                token.setToken(tokenStr);
            }
        }
        return token;
    }

    /**
     * 创建新token
     * @param appId
     * @return
     */
    private String createNewToken(String appId){
        //获取当前时间
        Date now = new Date(System.currentTimeMillis());
        //过期时间
        Date expiration = new Date(now.getTime() + 7200000);
        return Jwts
                .builder()
                .setSubject(appId)//设置的用户对象
                .setIssuedAt(now)
                .setIssuer("Online YAuth Builder")
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256,"ZTESTAuthv1.0.0")//签名生成规则
                .compact();
    }
}
