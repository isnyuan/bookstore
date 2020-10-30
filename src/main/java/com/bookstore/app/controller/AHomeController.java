package com.bookstore.app.controller;

import com.bookstore.app.service.AHomeService;
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
 * 时间：2020/04/14
 * 功能：首页轮播图controller类、热门商品controller类
 */

@RestController
@RequestMapping("/app/home")
@Validated
public class AHomeController {


    //日志
    private final Logger logger = LoggerFactory.getLogger(AHomeController.class);

    //注入HomeService类
    @Resource
    private AHomeService aHomeService;

    /**
     * 作者：李丹涛
     * 时间：2020/04/14
     * 功能：查询首页轮播图接口
     */
    @PostMapping("/listRotate")
    public Response listRotate() {
        try {
            return aHomeService.listRotate();
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询首页轮播图有误！");
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/14晚上19：54
     * 功能：分页查询热门商品接口
     */
    @PostMapping("/listHotGoods")
    public Response listHotGoods(){
        try {
            return aHomeService.listHotGoods();
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询首页热门商品有误！");
        }
    }


}
