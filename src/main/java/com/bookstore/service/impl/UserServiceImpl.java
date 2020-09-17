package com.bookstore.service.impl;

import com.bookstore.dao.UserDao;
import com.bookstore.entity.UserDTO;
import com.bookstore.entity.UserInfo;
import com.bookstore.service.UserService;
import com.bookstore.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    //添加事务
    //@Transactional(rollbackFor = Exception.class)
    public Response addUser(UserInfo userInfo) {
        /*
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
            userInfo.setCreateUser(SecurityUtils.getCurrentUserId());
            userInfo.setLastUpdateUser(SecurityUtils.getCurrentUserId());
            int flag = userDao.addUser(userInfo);
            if (flag > 0) {
                return Response.success("新增用户成功！");
            } else {
                //新增失败，事务回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Response.error("新增用户有误！");
            }
        }*/
        return null;
    }

    @Override
    public Response findUser(String userCode) {
        UserInfo userInfo = userDao.findUser(userCode);
        if (userInfo == null) {
            return Response.error("未查询到相关用户信息！");
        } else {
            return Response.success("查询成功!", userInfo);
        }
    }

    @Override
    public Response listUser(UserInfo userInfo) {
        return null;
    }

    @Override
    public Response updateUser(UserInfo userInfo) {
        return null;
    }

    @Override
    public Response deleteUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public Response updatePassword(UserInfo userInfo) {
        return null;
    }
}
