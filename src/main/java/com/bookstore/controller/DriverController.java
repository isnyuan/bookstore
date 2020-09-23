package com.bookstore.controller;

import com.bookstore.entity.DriverDTO;
import com.bookstore.entity.DriverInfo;
import com.bookstore.service.DriverService;
import com.bookstore.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/driver")
public class DriverController {

    //日志
    private final Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Autowired
    private DriverService driverService;

    /**
     * 作者：李丹涛
     * 时间：2020/04/14下午15：41
     * 司机角色编号 4
     */
    private static final String ROLE = "4";



    /**
     * 作者：李丹涛
     * 时间：2020/04/14凌晨01：51分
     * 功能：新增司机信息接口
     * driverInfo：司机实体类信息
     */
    @PostMapping("/addDriver")
    public Response addDriver(DriverInfo driverInfo){
        try {
            driverInfo.setRole(ROLE);
            return driverService.addDriver(driverInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("新增司机操作有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/14凌晨01：51分
     * 功能：查询司机信息详情接口
     * driverCode：司机编号
     */
    @PostMapping("/findDriver")
    public Response findDriver(String driverCode){
        try {
            return driverService.findDriver(driverCode);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询司机信息有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/14凌晨01：51分
     * 功能：分页查询司机接口
     * driverInfo：司机实体类信息
     */
    @PostMapping("/listDriver")
    public Response listDriver(DriverInfo driverInfo){
        try {
            return driverService.listDriver(driverInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("分页查询司机信息有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/14凌晨01：51分
     * 功能：修改司机信息接口
     * driverInfo：司机实体类信息
     */
    @PostMapping("/updateDriver")
    public Response updateDriver(DriverInfo driverInfo){
        try {
            return driverService.updateDriver(driverInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("修改司机信息有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/14凌晨01：51分
     * 功能：删除司机信息接口
     * driverDTO：前端传多参数使用实体类
     */
    @PostMapping("/deleteDriver")
    public Response deleteDriver(DriverDTO driverDTO){
        try {
            return driverService.deleteDriver(driverDTO);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("司机信息有误！");
        }
    }

}
