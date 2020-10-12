package com.bookstore.admin.controller;

import com.bookstore.admin.entity.MenuInfo;
import com.bookstore.admin.service.MenuService;
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
 * 时间：2020/04/16凌晨00：42分
 * 功能：菜单管理controller类
 */

@RestController
@RequestMapping("/pc/menu")
@Validated
public class MenuController {

    //日志
    private final Logger logger = LoggerFactory.getLogger(MenuController.class);

    //注入MenuService类
    @Autowired
    private MenuService menuService;

    /**
     * 作者：李丹涛
     * 时间：2020/04/16凌晨00：42分
     * 功能：查询全部菜单列表
     */
    @PostMapping("/listMenu")
    public Response listMenu(){
        try {
            return menuService.listMenu();
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询菜单列表有误！");
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/16凌晨00：42分
     * 功能：根据角色查询首页菜单
     * （角色0：管理员可查看全部菜单，角色1：店长可看客户、订单、门店、司机菜单）
     */
    @PostMapping("/listMenuHome")
    public Response listMenuHome(String userRole){
        try {
            return menuService.listMenuHome(userRole);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询菜单列表有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/16凌晨00：42分
     * 功能：新增菜单
     */
    @PostMapping("/addMenu")
    public Response addMenu(MenuInfo menuInfo){
        try {
            return menuService.addMenu(menuInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询菜单列表有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/16凌晨00：42分
     * 功能：查看菜单详情
     */
    @PostMapping("/findMenu")
    public Response findMenu(String menuCode){
        try {
            return menuService.findMenu(menuCode);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查看菜单详情有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/16凌晨00：42分
     * 功能：修改菜单
     */
    @PostMapping("/updateMenu")
    public Response updateMenu(MenuInfo menuInfo){
        try {
            return menuService.updateMenu(menuInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("修改菜单有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/16凌晨00：42分
     * 功能：删除菜单
     */
    @PostMapping("/deleteMenu")
    public Response deleteMenu(MenuInfo menuInfo){
        try {
            return menuService.deleteMenu(menuInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("删除菜单有误！");
        }
    }
}
