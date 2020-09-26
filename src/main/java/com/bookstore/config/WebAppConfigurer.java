package com.bookstore.config;

import com.bookstore.page.PageInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 功能描述: 拦截器配置类
 * @Author: lihuizong
 * @Date: 2020/9/26 12:21
 */
@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {

    /**
     * 分页拦截器
     */
    @Autowired
    private PageInterceptor pageInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(pageInterceptor).addPathPatterns("/**");
    }
}
