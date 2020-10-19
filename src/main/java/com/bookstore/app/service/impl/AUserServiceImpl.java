package com.bookstore.app.service.impl;

import com.alibaba.fastjson.JSON;
import com.bookstore.app.dao.AUserDao;
import com.bookstore.app.entity.AUserInfo;
import com.bookstore.app.service.AUserService;
import com.bookstore.utils.PasswordUtils;
import com.bookstore.utils.Response;
import com.bookstore.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class AUserServiceImpl implements AUserService {

    //注入查询用户dao类
    @Autowired
    private AUserDao aUserDao;

    /**
     * 作者：李丹涛
     * 时间：2020/04/19早上10：12分
     * 功能：角色
     */
    //店长
    private static final String STORE = "1";
    //客户
    private static final String CUSTOMER = "3";
    //司机
    private static final String DRIVER = "4";

    /**
     * 作者：李丹涛
     * 时间：2020/04/19凌晨02：41分
     * 功能：查询个人信息
     */
    @Override
    public Response findUser(){
        String userCode = SecurityUtils.getCurrentUserCode();
        System.out.println(userCode);
        //先找用户表基本所需信息
        AUserInfo userInfo = aUserDao.findUser(userCode);
        System.out.println(JSON.toJSON(userInfo));
        //查询是什么角色
        String role = aUserDao.checkRole(userCode);
        AUserInfo userInfo1 = new AUserInfo();
        //店长
        if(role.equals(STORE)){
            userInfo1 = aUserDao.findStore(userCode);
            String address = userInfo1.getProvinceName()+userInfo1.getCityName()+userInfo1.getCityName()+userInfo1.getAddress();
            userInfo1.setAddress(address);
        }
        //客户
        if(role.equals(CUSTOMER)){
            userInfo1 = aUserDao.findCustomer(userCode);
            String address = userInfo1.getProvinceName()+userInfo1.getCityName()+userInfo1.getCityName()+userInfo1.getAddress();
            userInfo1.setAddress(address);
        }
        //司机
        if(role.equals(DRIVER)){
            userInfo1 = aUserDao.findDriver(userCode);
        }
        //用户基本信息塞进同一实体类整合
        userInfo1.setUserName(userInfo.getUserName());
        userInfo1.setUserImagePath(userInfo.getUserImagePath());
        userInfo1.setRole(userInfo.getRole());
        if(userInfo1==null){
            return Response.error("未查询相关信息，请重新查找！");
        }else {
            return Response.success("查询成功！",userInfo1);
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/19凌晨02：43分
     * 功能：修改密码
     */
    @Override
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response updateUserPassword(AUserInfo userInfo){
        String userCode = SecurityUtils.getCurrentUserCode();
        //String userCode = "20200418160238835042";
        userInfo.setUserCode(userCode);
        //设置当前修改者编码
        userInfo.setLastUpdateUser(SecurityUtils.getCurrentUserCode());
        //密码校验过程
        //获取旧的存在数据库的司机信息
        String userPassword = aUserDao.findUserPassword(userCode);
        //获取原密码（上一次修改或添加的已加密的原密码）
        String oldPassord = userPassword;
        //获取原密码（本次修改密码传的原密码是未加密的哦）
        String newPassword = userInfo.getUserPassword();
        //比较密码是否相同
        Boolean isEquals = new BCryptPasswordEncoder().matches(newPassword, oldPassord);
        if (isEquals) {
            userInfo.setUserNewPassword(PasswordUtils.generatePassword(userInfo.getUserNewPassword()));
            int update = aUserDao.updateUserPassword(userInfo);
            if (update > 0) {
                return Response.success("修改密码成功！");
            } else {
                //修改失败,事务回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Response.error("修改密码有误！");
            }
        } else {
            return Response.error("原密码错误，请重新输入！");
        }
    }
}
