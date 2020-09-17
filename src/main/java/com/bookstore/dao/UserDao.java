package com.bookstore.dao;

import com.bookstore.entity.UserDTO;
import com.bookstore.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    /**
     * 作者：李丹涛
     * 时间：2020/04/10晚上22：09分
     * 功能：查询账号或手机是否存在，userInfo用户信息
     */
    int checkUser(UserInfo userInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/10晚上22：09分
     * 功能：新增用户，userInfo用户信息
     */
    int addUser(UserInfo userInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/10晚上22：09分
     * 功能：查询用户详情，userCode用户编号
     */
    UserInfo findUser(String userCode);

    /**
     * 作者：李丹涛
     * 时间：2020/04/10晚上22：09分
     * 功能：查查询用户分页列表信息，userInfo用户信息
     */
    List<UserInfo> listUserByPage(UserInfo userInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/10晚上22：09分
     * 功能：修改用户，userInfo用户信息
     */
    int updateUser(UserInfo userInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/10晚上22：09分
     * 功能：删除用户，userDTO用户form传的参数
     */
    int deleteUser(UserDTO userDTO);

    /**
     * 作者：李丹涛
     * 时间：2020/04/15晚上22：41分表
     * 功能：管理员修改用户密码（无需校对原密码，强制修改）
     */
    int updatePassword(UserInfo userInfo);
}
