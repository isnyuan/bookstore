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
        http
                .formLogin() // 登录
                .loginPage("/login.html") // 登录页面
                .loginProcessingUrl("/login") // 登录请求地址
                .usernameParameter("username") // 用户名
                .passwordParameter("password") // 密码
                .defaultSuccessUrl("/index.html") // 成功跳转页面路径
                .failureUrl("/login.html") // 失败跳转页面路径
                .and()
                .authorizeRequests() // 授权请求
                .antMatchers("/login", "/index", "/", "/user/test").permitAll() // 这些路径所有人可以访问
                .antMatchers("/user/**").hasRole("admin") // 角色为admin
                .antMatchers("/user/**").authenticated() // 需要经过身份认证
                .and()
                .logout() // 登出
                .deleteCookies("remove") // 登出后清除cookie
                .and()
                .csrf().disable() // 关闭csrf跨域
                .httpBasic(); // http基本认证:每次请求api时都提供用户的username和password

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
