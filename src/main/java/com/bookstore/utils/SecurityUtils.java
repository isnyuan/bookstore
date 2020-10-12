package com.bookstore.utils;

import com.bookstore.admin.entity.SecurityUser;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 功能描述: SecurityUtils工具类
 * @Author: lihuizong
 * @Date: 2020/9/20 14:30
 */
public class SecurityUtils {

    /**
     * 功能描述: 获取当前用户编号
     * @Author: lihuizong
     * @Date: 2020/9/20 14:29
     */
    public static String getCurrentUserCode(){
        SecurityUser securityUser = (SecurityUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //System.out.println(securityUser.toString());
        return securityUser.getUsercode();
    }

    /**
     * 功能描述: 获取当前用户账户
     * @Author: lihuizong
     * @Date: 2020/9/21 14:27
     */
    public static String getCurrentUserAccount(){
        SecurityUser securityUser = (SecurityUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return securityUser.getUsername();
    }

    /**
     * 功能描述: 获取当前用户角色
     * @Author: lihuizong
     * @Date: 2020/9/21 14:27
     */
    public static String getCurrentUserRole(){
        SecurityUser securityUser = (SecurityUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return securityUser.getRole();
    }

    /**
     * 功能描述: 获取当前用户详细信息
     * @Author: lihuizong
     * @Date: 2020/9/20 14:30
     */
    public static Object getCurrentUserDetail(){
        SecurityUser securityUser = (SecurityUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return securityUser;
    }
}
