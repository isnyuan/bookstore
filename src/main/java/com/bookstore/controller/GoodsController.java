package com.bookstore.controller;

import com.bookstore.entity.GoodsCateInfo;
import com.bookstore.entity.GoodsDTO;
import com.bookstore.entity.GoodsInfo;
import com.bookstore.service.GoodsService;
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
 * 时间：2020/04/11晚上22：49分
 * 功能：商品管理GoodsController类
 */

@RestController
@RequestMapping("/goods")
@Validated
public class GoodsController {

    //日志
    private final Logger logger = LoggerFactory.getLogger(GoodsController.class);

    //注入GoodsService类
    @Resource
    private GoodsService goodsService;

    /**
     * 作者：李丹涛
     * 时间：2020/04/11晚上22：49分
     * 功能：查询商品分类下拉框接口，goodsCateInfo为商品分类实体类信息
     */
    @PostMapping("/listGoodsCate")
    public Response listGoodsCate(GoodsCateInfo goodsCateInfo) {
        try {
            return goodsService.listGoodsCate(goodsCateInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询商品分类下拉框有误！");
        }
    }



    /**
     * 作者：李丹涛
     * 时间：2020/04/11晚上22：49分
     * 功能：新增商品接口，goodsInfo商品信息
     */
    @PostMapping("/addGoods")
    public Response addGoods(GoodsInfo goodsInfo) {
        try {
            return goodsService.addGoods(goodsInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("新增商品操作有误！");
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/11晚上22：49分
     * 功能：查询商品详情接口，goodsCode商品编号
     */
    @PostMapping("/findGoods")
    public Response findGoods(String goodsCode) {
        try {
            return goodsService.findGoods(goodsCode);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询商品详情操作有误！");
        }
    }



    /**
     * 作者：李丹涛
     * 时间：2020/04/11晚上22：49分
     * 功能：分页查询商品列表接口，goodsInfo商品信息
     */
    @PostMapping("/listGoods")
    public Response listGoods(GoodsInfo goodsInfo) {
        try {
            return goodsService.listGoods(goodsInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("分页查询商品列表信息操作有误！");
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/11晚上22：49分
     * 功能：修改商品接口，goodsInfo商品信息
     */
    @PostMapping("/updateGoods")
    public Response updateGoods(GoodsInfo goodsInfo) {
        try {
            return goodsService.updateGoods(goodsInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("修改商品操作有误！");
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/11晚上22：49分
     * 功能：修改商品状态接口，goodsDTO用户form传的参数
     */
    @PostMapping("/updateGoodsActive")
    public Response updateGoodsActive(String goodsCodeList,String versionList, String goodsActive){
        try {
            return goodsService.updateGoodsActive(goodsCodeList,versionList,goodsActive);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("修改商品状态操作有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/11晚上22：49分
     * 功能：删除商品接口，goodsDTO用户form传的参数
     */
    @PostMapping("/deleteGoods")
    public Response deleteGoods(GoodsDTO goodsDTO) {
        try {
            return goodsService.deleteGoods(goodsDTO);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("删除商品操作有误！");
        }
    }
}
