package com.bookstore.admin.service;

import com.bookstore.admin.entity.UserDTO;
import com.bookstore.admin.entity.UserInfo;
import com.bookstore.utils.Response;

public interface UserService {

    /**
     * 功能描述: 新增用户
     * @Author: lihuizong
     * @Date: 2020/9/16 19:36
     */
    Response addUser(UserInfo userInfo);

    /**
     * 功能描述: 查找用户通过用户编号
     * @Author: lihuizong
     * @Date: 2020/9/16 19:40
     */
    Response findUser(String userCode);

    /**
     * 功能描述: 查询用户列表信息
     * @Author: lihuizong
     * @Date: 2020/9/16 19:37
     */
    Response listUser(UserInfo userInfo);

    /**
     * 功能描述: 修改用户信息
     * @Author: lihuizong
     * @Date: 2020/9/16 19:40
     */
    Response updateUser(UserInfo userInfo);

    /**
     * 功能描述: 删除用户
     * @Author: lihuizong
     * @Date: 2020/9/16 19:41
     */
    Response deleteUser(UserDTO userDTO);

    /**
     * 功能描述: 修改密码
     * @Author: lihuizong
     * @Date: 2020/9/16 19:43
     */
    Response updatePassword(UserInfo userInfo);
}
