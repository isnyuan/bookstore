package com.bookstore.app.controller;

import com.bookstore.app.service.ADriverService;
import com.bookstore.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 作者：李丹涛
 * 时间：2020/04/15下午15：09分
 * 功能：查询司机负责门店，店长的相关信息Controller类，
 */

@RestController
@RequestMapping("/app/driverHome")
@Validated
public class ADriverController {

    //日志
    private final Logger logger = LoggerFactory.getLogger(ADriverController.class);

    //注入StoreService类
    @Autowired
    private ADriverService aDriverService;

    /**
     * 作者：李丹涛
     * 时间：2020/04/15下午15：09分
     * 功能：查询司机负责门店，店长的相关信息，
     */
    @PostMapping("/findDriverStore")
    public Response findDriverStore(){
        try {
            return aDriverService.findDriverStore();
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询司机负责门店，店长的相关信息有误！");
        }
    }
}
