package com.bookstore.service.impl;

import com.bookstore.dao.UserDao;
import com.bookstore.entity.SecurityUser;
import com.bookstore.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 功能描述: Spring Security连接数据库的核心
 * @Author: lihuizong
 * @Date: 2020/9/21 11:30
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;


    /**
     * 功能描述: 重写接口loadUserByUsername方法，完成数据库的查询工作
     * @Author: lihuizong
     * @Date: 2020/9/21 11:33
     */
    @Override
    public UserDetails loadUserByUsername(String userAccount) throws UsernameNotFoundException {
        if (userAccount == null || "".equals(userAccount)) {
            throw new RuntimeException("用户不能为空");
        }
        UserInfo userInfo = userDao.findUserByAccount(userAccount);

        if (userInfo == null) {
            return null;
        } else {
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            // 添加角色
            authorities.add(new SimpleGrantedAuthority("ROLE_"+userInfo.getUserRole()));
            // 添加用户信息
            SecurityUser user = new SecurityUser(userInfo.getUserCode(), userInfo.getUserAccount(), userInfo.getUserPassword(), userInfo.getUserRole(), authorities);
            //System.out.println("管理员信息："+user.getUsername()+"   "+userInfo.getUserPassword()+"  "+user.getAuthorities());
            return user;
        }
    }
    
}
