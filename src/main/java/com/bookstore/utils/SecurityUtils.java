package com.bookstore.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 功能描述: SecurityUtils工具类
 * @Author: lihuizong
 * @Date: 2020/9/20 14:30
 */
public class SecurityUtils {

    /**
     * 功能描述: 获取当前用户用户名
     * @Author: lihuizong
     * @Date: 2020/9/20 14:29
     */
    public static Authentication getUserAuthentication(){
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        return SecurityContextHolder.getContext().getAuthentication();
    }
    
    /**
     * 功能描述: 获取当前用户信息
     * @Author: lihuizong
     * @Date: 2020/9/20 14:30
     */
    public static Object getCurrentPrincipal(){
        System.out.println(getUserAuthentication().getPrincipal());
        return getUserAuthentication().getPrincipal();
    }
}
