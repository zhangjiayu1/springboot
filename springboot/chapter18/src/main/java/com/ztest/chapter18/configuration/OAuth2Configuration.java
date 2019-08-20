package com.ztest.chapter18.configuration;

import com.ztest.chapter18.Authorities;
import com.ztest.chapter18.CustomAuthenticationEntryPoint;
import com.ztest.chapter18.CustomLogoutSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/20
 * \* Time: 10:11
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 18
 * \* @EnableAuthorizationServer注解开启了验证服务器
 */
@Configuration
public class OAuth2Configuration {

    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter{

        @Autowired
        private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

        @Autowired
        private CustomLogoutSuccessHandler customLogoutSuccessHandler;

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http
                    .exceptionHandling()
                    .authenticationEntryPoint(customAuthenticationEntryPoint)
                    .and()
                    .logout()
                    .logoutUrl("/oauth/logout")
                    .logoutSuccessHandler(customLogoutSuccessHandler)
                    .and()
                    .authorizeRequests()
                    .antMatchers("/hello/").permitAll()
                    .antMatchers("/secure/**").authenticated();

        }
    }

    @Configuration
    @EnableAuthorizationServer
    protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter{

        private static final String ENV_OAUTH = "authentication.oauth.";
        private static final String PROP_CLIENTID = "clientid";
        private static final String PROP_SECRET = "secret";
        private static final String PROP_TOKEN_VALIDITY_DECONDS = "tokenValidityInSeconds";

        @Autowired
        private DataSource dataSource;

        @Autowired
        private PasswordEncoder passwordEncoder;

        @Bean
        public TokenStore tokenStore(){
            return new JdbcTokenStore(dataSource);
        }

        @Autowired
        @Qualifier("authenticationManagerBean")
        private AuthenticationManager authenticationManager;

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            endpoints
                    .tokenStore(tokenStore())
                    .authenticationManager(authenticationManager);
        }

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            clients
                    .inMemory()
                    .withClient("zjy_home_pc")
                    .scopes("read","write")
                    .authorities(Authorities.ROLE_ADMIN.name(),Authorities.ROLE_USER.name())
                    .additionalInformation("model","test")
                    .authorizedGrantTypes("password","refresh_token")
                    .secret(passwordEncoder.encode("zjy_secret"))
                    .accessTokenValiditySeconds(1800);
        }
    }
}
