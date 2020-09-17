package com.bookstore.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 功能描述: 加密工具类
 * @Author: lihuizong
 * @Date: 2020/9/16 20:00
 */
public class PasswordUtils {

    public static String generatePassword(String rawPassword) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(rawPassword);
    }

}
