package com.bookstore.service.impl;

import com.bookstore.dao.DriverDao;
import com.bookstore.entity.DriverDTO;
import com.bookstore.entity.DriverInfo;
import com.bookstore.service.DriverService;
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
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverDao driverDao;


    /**
     * 作者：李丹涛
     * 时间：2020/04/14凌晨01：51分
     * 功能：新增司机信息接口
     * driverInfo：司机实体类信息
     */
    @Override
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response addDriver(DriverInfo driverInfo) {
        //检查账号或手机号是否被用户注册过
        int count = driverDao.checkDriver(driverInfo);
        if (count > 0) {
            return Response.error("账号或手机号已存在，请重新填写！");
        } else {
            //设置创建者和修改者
            driverInfo.setCreateUser(SecurityUtils.getCurrentUserCode());
            driverInfo.setLastUpdateUser(SecurityUtils.getCurrentUserCode());
            //随机司机编号,返回数据:时间戳+3为随机数
            driverInfo.setDriverCode(StringUtil.getCommonCode(3));
            //删除标记：未删除0
            driverInfo.setIsDelete("0");
            //加密密码
            driverInfo.setUserPassword(PasswordUtils.generatePassword(driverInfo.getUserPassword()));
            //新增用户表信息
            int add1 = driverDao.addUser(driverInfo);
            //新增司机信息
            int add2 = driverDao.addDriver(driverInfo);
            if (add1 > 0 && add2 > 0) {
                return Response.success("新增司机司机成功！");
            } else {
                return Response.error("提供的新增信息有误！");
            }
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/14凌晨01：51分
     * 功能：查询司机信息详情接口
     * driverCode：司机编号
     */
    @Override
    public Response findDriver(String driverCode){
        DriverInfo driverInfo = driverDao.findDriver(driverCode);
        if (driverInfo != null) {
            driverInfo.setUserPassword(PasswordUtils.generatePassword(driverInfo.getUserPassword()));
            return Response.success("查询司机信息详情成功！", driverInfo);
        } else {
            return Response.error("未查询到相关司机信息");
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/14凌晨01：51分
     * 功能：分页查询司机接口
     * driverInfo：司机实体类信息
     */
    @Override
    public Response listDriver(DriverInfo driverInfo){
        //mybaties模糊查询避免与查询混淆
        driverInfo.setOutDriverCode(driverInfo.getDriverCode());
        driverInfo.setOutUserName(driverInfo.getUserName());
        //获取当前用户编号，如果登录角色是店长，关联查询门下司机信息
        driverInfo.setDriverCode(SecurityUtils.getCurrentUserCode());
        List<DriverInfo> list = driverDao.listDriverByPage(driverInfo);
        if (list.size() == 0) {
            return Response.error("未查询到相关司机信息！");
        } else {
            //return Response.success("查询成功！", getPageInfo(list));
            return Response.success("查询成功！", list);
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/14凌晨01：51分
     * 功能：修改司机信息接口
     * driverInfo：司机实体类信息
     */
    @Override
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response updateDriver(DriverInfo driverInfo) {
        //设置当前修改者编码
        driverInfo.setLastUpdateUser(SecurityUtils.getCurrentUserCode());
        //检验修改的手机号或账号是否被注册
        int exitPhoneAccount = driverDao.checkUpdateDriver(driverInfo);
        //被注册则结束返回
        if (exitPhoneAccount > 0) {
            return Response.error("账号或手机号已存在，请重新填写！");
        }
        //加密密码
        driverInfo.setUserPassword(PasswordUtils.generatePassword(driverInfo.getUserPassword()));
        //修改用户表信息
        int update1 = driverDao.updateUser(driverInfo);
        //修改司机表信息
        int update2 = driverDao.updateDriver(driverInfo);
        if (update1 > 0 && update2 > 0) {
            return Response.success("修改司机信息成功！");
        } else {
            //修改失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("修改司机信息有误！");
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/14凌晨01：51分
     * 功能：删除司机信息接口
     * driverDTO：前端传多参数使用实体类
     */
    @Override
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response deleteDriver(DriverDTO driverDTO) {
        //设置当前修改者编码
        driverDTO.setLastUpdateUser(SecurityUtils.getCurrentUserCode());
        //删除用户表信息与司机表信息
        int delete1 = driverDao.deleteUser(driverDTO);
        int delete2 = driverDao.deleteDriver(driverDTO);
        if (delete1 > 0 && delete2 > 0) {
            return Response.success("删除成功！");
        } else {
            //删除失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("删除司机信息操作有误！");
        }
    }
}
