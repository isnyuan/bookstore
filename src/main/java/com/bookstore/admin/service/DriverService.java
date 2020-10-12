package com.bookstore.admin.service;

import com.bookstore.admin.entity.DriverDTO;
import com.bookstore.admin.entity.DriverInfo;
import com.bookstore.utils.Response;

public interface DriverService {

    /**
     * 功能描述: 新增司机信息
     * @Author: lihuizong
     * @Date: 2020/9/22 12:19
     */
    public Response addDriver(DriverInfo driverInfo);

    /**
     * 功能描述: 查询司机信息详情
     * @Author: lihuizong
     * @Date: 2020/9/22 12:19
     */
    public Response findDriver(String driverCode);

    /**
     * 功能描述: 查询司机
     * @Author: lihuizong
     * @Date: 2020/9/22 12:20
     */
    public Response listDriver(DriverInfo driverInfo);

    /**
     * 功能描述: 修改司机信息
     * @Author: lihuizong
     * @Date: 2020/9/22 12:20
     */
    public Response updateDriver(DriverInfo driverInfo);

    /**
     * 功能描述: 删除司机信息
     * @Author: lihuizong
     * @Date: 2020/9/22 12:20
     */
    public Response deleteDriver(DriverDTO driverDTO);
    
}
