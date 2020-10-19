package com.bookstore.app.controller;

import com.bookstore.app.entity.AShopCarDTO;
import com.bookstore.app.entity.AShopCarInfo;
import com.bookstore.app.service.AShopCarService;
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
 * 时间：2020/04/15中午11：49分
 * 功能：购物车GoodsController类
 */

@RestController
@RequestMapping("/app/shopCar")
@Validated
public class AShopCarController {

    //日志
    private final Logger logger = LoggerFactory.getLogger(AShopCarController.class);

    //注入GoodsService类
    @Resource
    private AShopCarService aShopCarService;

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午11：33分
     * 功能：新增购物车接口，ShopCarInfo为购物车实体类信息
     */
    @PostMapping("/addShopCar")
    public Response addShopCar(AShopCarInfo shopCarInfo){
        try {
            return aShopCarService.addShopCar(shopCarInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("新增购物车有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午11：33分
     * 功能：查询购物车接口
     */
    @PostMapping("/listShopCar")
    public Response listShopCar(){
        try {
            return aShopCarService.listShopCar();
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询购物车有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午11：33分
     * 功能：修改购物车接口，ShopCarInfo为购物车实体类信息
     */
    @PostMapping("/updateShopCar")
    public Response updateShopCar(AShopCarInfo shopCarInfo){
        try {
            return aShopCarService.updateShopCar(shopCarInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("修改购物车有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午11：33分
     * 功能：删除购物车接口，shopCarDTO为接受前端多参信息
     */
    @PostMapping("/deleteShopCar")
    public Response deleteShopCar(AShopCarDTO shopCarDTO){
        try {
            return aShopCarService.deleteShopCar(shopCarDTO);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("删除购物车有误！");
        }
    }
}
