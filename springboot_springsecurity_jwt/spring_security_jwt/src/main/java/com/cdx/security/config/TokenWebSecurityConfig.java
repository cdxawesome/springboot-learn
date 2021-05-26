package com.cdx.security.config;

import com.cdx.security.filter.TokenAuthenticationFilter;
import com.cdx.security.filter.TokenLoginFilter;
import com.cdx.security.handler.UnauthorizedEntryPoint;
import com.cdx.security.util.DefaultPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 核心配置类
 */
/*
TODO:下面这几个注解是啥意思啊
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class TokenWebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 密码管理工具类
     */
    @Autowired
    private DefaultPasswordEncoder defaultPasswordEncoder;

    /**
     * 用户服务类
     */
    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * 配置设置，设置退出的地址和token
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling()
                // 未授权处理
                .authenticationEntryPoint(new UnauthorizedEntryPoint())
                .and().authorizeRequests()
                .anyRequest().authenticated()
                .and().csrf().disable()
                .logout().logoutUrl("/logout")
                .and()
                .addFilter(new TokenLoginFilter(authenticationManager()))
                .addFilter(new TokenAuthenticationFilter(authenticationManager())).httpBasic();
    }

    /**
     * 密码处理
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(defaultPasswordEncoder);
    }

    /**
     * 配置哪些请求不被拦截
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/index**", "/api/**", "/swagger-ui.html/**");
    }
}
