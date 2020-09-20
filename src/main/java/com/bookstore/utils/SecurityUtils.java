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
     * 功能描述: 获取当前用户认证信息
     * @Author: lihuizong
     * @Date: 2020/9/20 14:29
     */
    public static Authentication getUserAuthentication(){
        return SecurityContextHolder.getContext().getAuthentication();
    }
    
    /**
     * 功能描述: 获取当前用户信息
     * @Author: lihuizong
     * @Date: 2020/9/20 14:30
     */
    public static Object getCurrentPrincipal(){
        return getUserAuthentication().getPrincipal();
    }
}
