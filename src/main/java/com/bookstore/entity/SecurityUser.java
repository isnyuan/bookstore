package com.bookstore.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

/**
 * 功能描述: 封装已认证用户信息
 * @Author: lihuizong
 * @Date: 2020/9/21 13:08
 */
public class SecurityUser implements Serializable, UserDetails {

    private String usercode;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;



    public SecurityUser(String userCode, String userAccount, String userPassword, Collection<? extends GrantedAuthority> authorities) {
        this.usercode = userCode;
        this.username = userAccount;
        this.password = userPassword;
        this.authorities = authorities;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "SecurityUser{" +
                "usercode='" + usercode + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}
