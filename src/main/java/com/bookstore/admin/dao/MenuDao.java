package com.bookstore.admin.dao;

import com.bookstore.admin.entity.MenuInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 作者：李丹涛
 * 时间：2020/04/16凌晨00：42分
 * 功能：菜单管理dao接口
 */

@Mapper
public interface MenuDao {

    /**
     * 作者：李丹涛
     * 时间：2020/04/16凌晨00：42分
     * 功能：查询全部菜单列表
     */
    List<MenuInfo> listMenu();

    /**
     * 作者：李丹涛
     * 时间：2020/04/16凌晨00：42分
     * 功能：根据角色查询首页菜单
     * （角色0：管理员可查看全部菜单，角色1：店长可看客户、订单、门店、司机菜单）
     */
    List<MenuInfo> listMenuHome(@Param("userRole") String userRole);

    /**
     * 作者：李丹涛
     * 时间：2020/04/16凌晨00：42分
     * 功能：新增菜单
     */
    int addMenu(MenuInfo menuInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/16凌晨00：42分
     * 功能：查看菜单详情
     */
    MenuInfo findMenu(String menuCode);

    /**
     * 作者：李丹涛
     * 时间：2020/04/16凌晨00：42分
     * 功能：修改菜单
     */
    int updateMenu(MenuInfo menuInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/16凌晨00：42分
     * 功能：删除菜单
     */
    int deleteMenu(MenuInfo menuInfo);
}
