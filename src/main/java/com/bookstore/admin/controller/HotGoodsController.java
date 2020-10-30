package com.bookstore.admin.controller;

import com.bookstore.admin.entity.HotGoodsDTO;
import com.bookstore.admin.entity.HotGoodsInfo;
import com.bookstore.admin.service.HotGoodsService;
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
 * 时间：2020/04/13中午10：31分
 * 功能：热门商品管理Controller类
 */

@RestController
@RequestMapping("/pc/hotGoods")
@Validated
public class HotGoodsController {

    //日志
    private final Logger logger = LoggerFactory.getLogger(HotGoodsController.class);

    //注入HotGoodsService类
    @Autowired
    private HotGoodsService hotGoodsService;


    /**
     * 作者：李丹涛
     * 时间：2020/04/13中午10：31分
     * 功能：新增热门商品接口,hotGoodsInfo是热门商品实体类信息
     */
    @PostMapping("/addHotGoods")
    public Response addHotGoods(HotGoodsInfo hotGoodsInfo){
        try {
            return hotGoodsService.addHotGoods(hotGoodsInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("新增热门商品有误！");
        }
    }



    /**
     * 作者：李丹涛
     * 时间：2020/04/13中午10：31分
     * 功能：查询热门商品详情接口,hotGoodsInfo是热门商品实体类信息
     */
    @PostMapping("/findHotGoods")
    public Response findHotGoods(String hotGoodsCode){
        try {
            return hotGoodsService.findHotGoods(hotGoodsCode);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询热门商品详情操作有误！");
        }
    }



    /**
     * 作者：李丹涛
     * 时间：2020/04/13中午10：31分
     * 功能：分页查询热门商品接口,hotGoodsInfo是热门商品实体类信息
     */
    @PostMapping("/listHotGoods")
    public Response listHotGoods(HotGoodsInfo hotGoodsInfo){
        try {
            return hotGoodsService.listHotGoods(hotGoodsInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询热门商品列表信息操作有误！");
        }
    }



    /**
     * 作者：李丹涛
     * 时间：2020/04/13中午10：31分
     * 功能：修改热门商品接口,hotGoodsInfo是热门商品实体类信息
     */
    @PostMapping("/updateHotGoods")
    public Response updateHotGoods(HotGoodsInfo hotGoodsInfo){
        try {
            return hotGoodsService.updateHotGoods(hotGoodsInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("修改热门商品操作有误！");
        }
    }



    /**
     * 作者：李丹涛
     * 时间：2020/04/13中午10：31分
     * 功能：查询热门商品展示数量接口
     */
    @PostMapping("/findHotGoodsShowNum")
    public Response findHotGoodsShowNum(){
        try {
            return hotGoodsService.findHotGoodsShowNum();
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询热门商品展示数量操作有误！");
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/13中午10：31分
     * 功能：修改热门商品数量展示接口,hotGoodsInfo是热门商品实体类信息
     */
    @PostMapping("/updateHotGoodsShowNum")
    public Response updateHotGoodsShowNum(HotGoodsInfo hotGoodsInfo){
        try {
            return hotGoodsService.updateHotGoodsShowNum(hotGoodsInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("修改热门商品数量展示操作有误！");
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/13中午10：31分
     * 功能：删除热门商品接口,hotGoodsDTO是前端传递多参数接收的实体类信息
     */
    @PostMapping("/deleteHotGoods")
    public Response deleteHotGoods(HotGoodsDTO hotGoodsDTO){
        try {
            return hotGoodsService.deleteHotGoods(hotGoodsDTO);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("删除热门商品操作有误！");
        }
    }

}
