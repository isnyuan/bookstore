package com.bookstore.app.service;

import com.bookstore.app.entity.AUserInfo;
import com.bookstore.utils.Response;

/**
 * 功能描述: 查询个人信息service接口
 * @Author: lihuizong
 * @Date: 2020/10/19 11:34
 */
public interface AUserService {

    /**
     * 功能描述: 查询个人信息
     * @Author: lihuizong
     * @Date: 2020/10/19 11:35
     */
    public Response findUser();

    /**
     * 功能描述: 修改密码
     * @Author: lihuizong
     * @Date: 2020/10/19 11:35
     */
    public Response updateUserPassword(AUserInfo userInfo);

}
