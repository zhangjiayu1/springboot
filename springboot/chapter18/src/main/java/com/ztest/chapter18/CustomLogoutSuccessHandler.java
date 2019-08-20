package com.ztest.chapter18;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/20
 * \* Time: 10:23
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 18 登出控制清空accessToken
 * \
 */
@Component
public class CustomLogoutSuccessHandler
        extends AbstractAuthenticationTargetUrlRequestHandler
        implements LogoutSuccessHandler {

    private static final String BEARER_AUTHENTICATION = "Bearer ";
    private static final String HEADER_AUTHORIZATION = "authorization";

    @Autowired
    private TokenStore tokenStore;

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Authentication authentication) throws IOException, ServletException {

        String token = httpServletRequest.getHeader(HEADER_AUTHORIZATION);
        if(token != null && token.startsWith(BEARER_AUTHENTICATION)){

            OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(token.split(" ")[0]);

            if(oAuth2AccessToken != null){
                tokenStore.removeAccessToken(oAuth2AccessToken);
            }
        }
    }
}
