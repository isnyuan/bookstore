package com.bookstore.app.service;

import com.bookstore.app.entity.ARegisterInfo;
import com.bookstore.utils.Response;

/**
 * 功能描述: 注册Service接口
 * @Author: lihuizong
 * @Date: 2020/10/19 14:22
 */
public interface ARegisterService {

    /**
     * 功能描述: 注册接口，registerInfo注册用户信息实体类
     * @Author: lihuizong
     * @Date: 2020/10/19 14:23
     */
    public Response clientRegister(ARegisterInfo registerInfo);
    
}
