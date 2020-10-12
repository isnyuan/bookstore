package com.bookstore.admin.service.impl;

import com.bookstore.admin.dao.UserDao;
import com.bookstore.admin.entity.UserDTO;
import com.bookstore.admin.entity.UserInfo;
import com.bookstore.page.PageUtils;
import com.bookstore.admin.service.UserService;
import com.bookstore.utils.PasswordUtils;
import com.bookstore.utils.Response;
import com.bookstore.utils.SecurityUtils;
import com.bookstore.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    // 添加用户
    @Override
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response addUser(UserInfo userInfo) {
        //查询账号或手机是否存在，userInfo用户信息
        int count = userDao.checkUser(userInfo);
        if (count > 0) {
            return Response.error("账号或手机号存在，请重新填写！");
        } else {
            //加密密码
            userInfo.setUserPassword(PasswordUtils.generatePassword(userInfo.getUserPassword()));
            //随机生成用户编号,返回数据:时间戳+3为随机数
            userInfo.setUserCode(StringUtil.getCommonCode(3));
            //删除标记：未删除0
            userInfo.setIsDelete("0");
            //设置创建者和修改者
            userInfo.setCreateUser(SecurityUtils.getCurrentUserCode());
            userInfo.setLastUpdateUser(SecurityUtils.getCurrentUserCode());
            int flag = userDao.addUser(userInfo);
            if (flag > 0) {
                return Response.success("新增用户成功！");
            } else {
                //新增失败，事务回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Response.error("新增用户有误！");
            }
        }
    }

    // 查找用户通过用户编号
    @Override
    public Response findUser(String userCode) {
        UserInfo userInfo = userDao.findUser(userCode);
        if (userInfo == null) {
            return Response.error("未查询到相关用户信息！");
        } else {
            return Response.success("查询成功!", userInfo);
        }
    }

    // 查询用户信息分页列表
    @Override
    public Response listUser(UserInfo userInfo) {
        List<UserInfo> userInfoList = userDao.listUserByPage(userInfo);
        if (userInfoList.size() == 0) {
            return Response.error("未查询到相关用户列表信息！");
        } else {
            //PageHelper.startPage(pageNum, pageSize);
            return Response.success("查询成功！", PageUtils.getPageInfo(userInfoList));
        }
    }

    // 更新用户
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response updateUser(UserInfo userInfo) {
        //设置当前修改者编码
        userInfo.setLastUpdateUser(SecurityUtils.getCurrentUserCode());
        //加密密码
        userInfo.setUserPassword(PasswordUtils.generatePassword(userInfo.getUserPassword()));
        int count = userDao.updateUser(userInfo);
        if (count > 0) {
            return Response.success("修改成功！");
        } else {
            //修改失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("修改用户有误！");
        }
    }

    // 删除用户
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response deleteUser(UserDTO userDTO) {
        userDTO.setLastUpdateUser(SecurityUtils.getCurrentUserCode());
        int count = userDao.deleteUser(userDTO);
        if (count > 0) {
            return Response.success("删除成功！");
        } else {
            //删除失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("删除用户操作有误！");
        }
    }

    // 修改密码
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response updatePassword(UserInfo userInfo) {
        //设置当前修改者编码
        userInfo.setLastUpdateUser(SecurityUtils.getCurrentUserCode());
        //加密密码
        userInfo.setUserPassword(PasswordUtils.generatePassword(userInfo.getUserPassword()));
        int count = userDao.updatePassword(userInfo);
        if (count > 0) {
            return Response.success("修改密码成功！");
        } else {
            //修改失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("密码格式有误！");
        }
    }
}
