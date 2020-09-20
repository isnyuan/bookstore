package com.bookstore.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 功能描述: 角色校验
 * @Author: lihuizong
 * @Date: 2020/9/20 12:03
 */
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        //忽略.html .css .js .img等文件
        web.ignoring().antMatchers("/**.css", "/img/**", "/**.js");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http
//                .csrf().disable() // 关闭跨域
//                .authorizeRequests() // 授权请求
//                .antMatchers("/login",
//                        "/api/**",
//                        "/**/heapdump",
//                        "/**/loggers",
//                        "/**/liquibase",
//                        "/**/logfile",
//                        "/**/flyway",
//                        "/**/auditevents",
//                        "/**/jolokia").permitAll() // 这些路径所有人可以访问
//                .and()
//                .authorizeRequests()
//                .antMatchers("/**").hasRole("USER") // 角色为USER
//                .antMatchers("/**").authenticated() // 需要经过身份认证
//                .and()
//                .formLogin() // 登录
//                .loginPage("/login.html") // 登录页面
//                .loginProcessingUrl("/login").permitAll()
//                .defaultSuccessUrl("/index.html") // 成功跳转页面路径
//                .and()
//                .logout() // 登出
//                .deleteCookies("remove") // 登出后清除cookie
//                .logoutSuccessUrl("/login.html").permitAll() // 登出成功后跳转的页面路径
//                .and()
//                .httpBasic(); // http基本认证:每次请求api时都提供用户的username和password

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").hasRole("admin")
                .antMatchers("/index").hasRole("admin")
                .and()
                .formLogin();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("zhangsan")
                .password(new BCryptPasswordEncoder().encode("123"))
                .roles("admin");
    }
}
