package com.bookstore.app.controller;

import com.bookstore.app.service.AStoreService;
import com.bookstore.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 作者：李丹涛
 * 时间：2020/04/15分下午14：16分
 * 功能：门店下司机信息controller类
 */

@RestController
@RequestMapping("/app/manangerInformation")
@Validated
public class AStoreController {

    //日志
    private final Logger logger = LoggerFactory.getLogger(AStoreController.class);

    //注入StoreService类
    @Resource
    private AStoreService aStoreService;

    /**
     * 作者：李丹涛
     * 时间：2020/04/15下午14：44分
     * 功能：店长个人信息之查询司机信息
     */
    @PostMapping("/listManangerDriver")
    public Response listManangerDriver(){
        try {
            return aStoreService.listManangerDriver();
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询司机信息有误！");
        }
    }

}
