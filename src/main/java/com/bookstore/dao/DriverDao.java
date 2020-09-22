package com.bookstore.dao;


import com.bookstore.entity.DriverDTO;
import com.bookstore.entity.DriverInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 作者：李丹涛
 * 时间：2020/04/14凌晨01：51分
 * 功能：司机管理dao接口
 */

@Mapper
public interface DriverDao {


    /**
     * 作者：李丹涛
     * 时间：2020/04/14凌晨01：51分
     * 功能：检查账号or手机号是否存在
     * driverInfo：司机实体类信息
     * (function)checkUpdateDriver:这个是更新的，要排除自己的手机号和账号，重复自己也可以的
     */
    int checkDriver(DriverInfo driverInfo);
    int checkUpdateDriver(DriverInfo driverInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/14凌晨01：51分
     * 功能：新增用户
     * driverInfo：司机实体类信息
     */
    int addUser(DriverInfo driverInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/14凌晨01：51分
     * 功能：新增司机信息接口
     * driverInfo：司机实体类信息
     */
    int addDriver(DriverInfo driverInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/14凌晨01：51分
     * 功能：查询司机信息详情接口
     * driverCode：司机编号
     */
    DriverInfo findDriver(String driverCode);

    /**
     * 作者：李丹涛
     * 时间：2020/04/14凌晨01：51分
     * 功能：分页查询司机接口
     * driverInfo：司机实体类信息
     */
    List<DriverInfo> listDriverByPage(DriverInfo driverInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/14凌晨01：51分
     * 功能：修改密码
     * driverInfo：司机实体类信息
     */
    int updateUser(DriverInfo driverInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/14凌晨01：51分
     * 功能：修改司机信息接口
     * driverInfo：司机实体类信息
     */
    int updateDriver(DriverInfo driverInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/14凌晨01：51分
     * 功能：删除司机信息接口
     * driverDTO：前端传多参数使用实体类
     * (function)deleteUser:删除关联用户账号信息
     */
    int deleteDriver(DriverDTO driverDTO);
    int deleteUser(DriverDTO driverDTO);


}
