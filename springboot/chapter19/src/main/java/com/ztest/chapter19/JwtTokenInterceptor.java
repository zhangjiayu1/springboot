package com.ztest.chapter19;

import com.ztest.chapter19.entity.ApiTokenInfos;
import com.ztest.chapter19.jpa.TokenJPA;
import com.ztest.chapter19.jpa.UserInfoJPA;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.commons.lang3.StringUtils;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import io.jsonwebtoken.SignatureException;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/21
 * \* Time: 16:35
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 19 获取token的路径排除在外拦截所有的路径，验证路径是否存在header包含token，并且验证token是否正确
 * \* finally保证抛出异常也继续执行
 */
public class JwtTokenInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenJPA tokenJPA;

    @Autowired
    private UserInfoJPA userInfoJPA;
    /**
     * 请求之前拦截处理
     * @param request 请求对象
     * @param response 返回对象
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        //自动排除生成token的路径，并且如果是options请求是cors跨域预请求，设置allow对应头信息
        if(request.getRequestURI().equals("/token") || RequestMethod.OPTIONS.toString().equals(request.getMethod())){
            return true;
        }
        //其他请求获取头信息
        final String authHeader = request.getHeader("X-YAuth-Token");
        ApiTokenInfos token = new ApiTokenInfos();
        try {
            //如果没有header信息
            if(StringUtils.isBlank(authHeader)){
                throw new SignatureException("not found X-YAuth-Token");
            }
            //获取jwt实体对象接口实例
            final Claims claims = Jwts.parser().setSigningKey("ZTESTAuthv1.0.0")
                    .parseClaimsJws(authHeader).getBody();
            //从数据库中获取token
            token = getDAO(TokenJPA.class,request).findAll(new Specification<ApiTokenInfos>() {
                @Override
                public Predicate toPredicate(Root<ApiTokenInfos> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                    criteriaQuery.where(criteriaBuilder.equal(root.get("appId"),claims.getSubject()));
                    return null;
                }
            }).get(0);
            //数据库中的token值
            String tokenval = new String(token.getAtiToken());
            //如果内存中不存在，提示客户端获取token
            if(StringUtils.isBlank(tokenval)){
                throw new SignatureException("not found token info,please get token again");
            }
            //判断内存中的token是否与客户端传来的一致
            if(!tokenval.equals(authHeader)){
                throw new SignatureException("not found token info,please get token again");
            }
        }//验证异常处理
        catch (SignatureException | ExpiredJwtException e){
            //输出对象
            PrintWriter writer = response.getWriter();
            //输出error消息
            writer.write("need refresh token");
            writer.close();
            return false;
        }//出现异常时
        catch (final Exception e){
            PrintWriter writer = response.getWriter();
            writer.write(e.getMessage());
            writer.close();
            return false;
        }finally {
            //数据库中的token值
            String tokenval = new String(token.getAtiToken());
            //如果内存中不存在，提示客户端获取token
            if(StringUtils.isBlank(tokenval)){
                throw new SignatureException("not found token info,please get token again");
            }
            //判断内存中的token是否与客户端传来的一致
            if(!tokenval.equals(authHeader)){
                throw new SignatureException("not found token info,please get token again");
            }
        }
        return true;
    }

    private <T> T getDAO(Class<T> clazz,HttpServletRequest request){
        BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        return factory.getBean(clazz);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
