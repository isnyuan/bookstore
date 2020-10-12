package com.bookstore.controller;

import com.bookstore.entity.GoodsCateInfo;
import com.bookstore.service.GoodsCateService;
import com.bookstore.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pc/goodsCate")
@Validated
public class GoodsCateController {

    //日志
    private final Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Autowired
    private GoodsCateService goodsCateService;

    /**
     * 作者：李丹涛
     * 时间：2020/04/12下午15：21分
     * 功能：新增商品分类接口,goodsCateInfo商品管理实体类信息
     */
    @PostMapping("/addGoodsCate")
    public Response addGoodsCate(GoodsCateInfo goodsCateInfo){
        try {
            return goodsCateService.addGoodsCate(goodsCateInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("新增商品分类有误！");
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/12下午15：21分
     * 功能：查询商品分类详情接口，goodsCateCode为热门商品编号
     */
    @PostMapping("/findGoodsCate")
    public Response findGoodsCate(String goodsCateCode){
        try {
            return goodsCateService.findGoodsCate(goodsCateCode);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询商品分类详情操作有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/12下午15：21分
     * 功能：查询商品分类列表接口
     */
    @PostMapping("/listGoodsCate")
    public Response listGoodsCate(){
        try {
            return goodsCateService.listGoodsCate();
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询商品分类列表信息操作有误！");
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/12下午15：21分
     * 功能：修改商品分类接口，goodsCateInfo商品分类信息
     */
    @PostMapping("/updateGoodsCate")
    public Response updateGoodsCate(GoodsCateInfo goodsCateInfo) {
        try {
            return goodsCateService.updateGoodsCate(goodsCateInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("修改商品分类操作有误！");
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/12下午15：21分
     * 功能：删除商品分类接口，goodsCateInfo为商品分类实体类信息
     */
    @PostMapping("/deleteGoodsCate")
    public Response deleteGoodsCate(GoodsCateInfo goodsCateInfo) {
        try {
            return goodsCateService.deleteGoodsCate(goodsCateInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("删除商品操作有误！");
        }
    }

}
