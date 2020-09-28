package com.bookstore.service;

import com.bookstore.entity.MenuInfo;
import com.bookstore.utils.Response;

/**
 * 功能描述: 菜单管理service接口
 * @Author: lihuizong
 * @Date: 2020/9/28 15:13
 */
public interface MenuService {

    /**
     * 功能描述: 查询全部菜单列表
     * @Author: lihuizong
     * @Date: 2020/9/28 15:13
     */
    public Response listMenu();

    /**
     * 功能描述: 根据角色查询首页菜单
     *      （角色0：管理员可查看全部菜单，角色1：店长可看客户、订单、门店、司机菜单）
     * @Author: lihuizong
     * @Date: 2020/9/28 15:13
     */
    public Response listMenuHome(String userRole);

    /**
     * 功能描述: 新增菜单
     * @Author: lihuizong
     * @Date: 2020/9/28 15:13
     */
    public Response addMenu(MenuInfo menuInfo);

    /**
     * 功能描述: 查看菜单详情
     * @Author: lihuizong
     * @Date: 2020/9/28 15:14
     */
    public Response findMenu(String menuCode);

    /**
     * 功能描述: 修改菜单
     * @Author: lihuizong
     * @Date: 2020/9/28 15:14
     */
    public Response updateMenu(MenuInfo menuInfo);

    /**
     * 功能描述: 删除菜单
     * @Author: lihuizong
     * @Date: 2020/9/28 15:14
     */
    public Response deleteMenu(MenuInfo menuInfo);

}
