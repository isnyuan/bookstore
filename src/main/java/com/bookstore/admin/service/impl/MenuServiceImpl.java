package com.bookstore.admin.service.impl;

import com.bookstore.admin.dao.MenuDao;
import com.bookstore.admin.entity.MenuInfo;
import com.bookstore.admin.service.MenuService;
import com.bookstore.utils.Response;
import com.bookstore.utils.SecurityUtils;
import com.bookstore.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    /**
     * 作者：李丹涛
     * 时间：2020/04/16凌晨00：42分
     * 功能：查询全部菜单列表
     */
    @Override
    public Response listMenu(){
        List<MenuInfo> list = menuDao.listMenu();
        if(list.size()==0){
            return Response.error("查询菜单信息有误！！");
        }else {
            return Response.success("查询菜单列表成功",list);
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/16凌晨00：42分
     * 功能：根据角色查询首页菜单
     * （角色0：管理员可查看全部菜单，角色1：店长可看客户、订单、门店、司机菜单）
     */
    @Override
    public Response listMenuHome(String userRole){
        List<MenuInfo> list = menuDao.listMenuHome(userRole);
        if(list.size()==0){
            return Response.error("查询菜单信息有误！！");
        }else {
            return Response.success("查询菜单列表成功",list);
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/16凌晨00：42分
     * 功能：新增菜单
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response addMenu(MenuInfo menuInfo){
        //设置创建者和修改者
        menuInfo.setCreateUser(SecurityUtils.getCurrentUserCode());
        menuInfo.setLastUpdateUser(SecurityUtils.getCurrentUserCode());
        //随机生成商品编号,返回数据:时间戳+3为随机数
        menuInfo.setMenuCode(StringUtil.getCommonCode(3));
        //删除标记：未删除0
        menuInfo.setIsDelete("0");
        int count = menuDao.addMenu(menuInfo);
        if (count > 0) {
            return Response.success("新增菜单信息成功！");
        } else {
            //新增失败，事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("新增菜单有误，请重新填写！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/16凌晨00：42分
     * 功能：查看菜单详情
     */
    @Override
    public Response findMenu(String menuCode){
        MenuInfo menuInfo = menuDao.findMenu(menuCode);
        if(menuInfo!=null){
            return Response.success("查询成功！",menuInfo);
        }else {
            return Response.error("提供的菜单编号有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/16凌晨00：42分
     * 功能：修改菜单
     */
    @Override
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response updateMenu(MenuInfo menuInfo){
        //设置当前修改者编码
        menuInfo.setLastUpdateUser(SecurityUtils.getCurrentUserCode());
        int count = menuDao.updateMenu(menuInfo);
        if (count > 0) {
            return Response.success("修改菜单成功！");
        } else {
            //修改失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("提供的菜单信息有误，请重新填写！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/16凌晨00：42分
     * 功能：删除菜单
     */
    @Override
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response deleteMenu(MenuInfo menuInfo){
        //设置当前修改者编码
        menuInfo.setLastUpdateUser(SecurityUtils.getCurrentUserCode());
        int count = menuDao.deleteMenu(menuInfo);
        if (count > 0) {
            return Response.success("删除菜单成功！");
        } else {
            //修改失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("提供的菜单编号有误，请重新填写！");
        }
    }
}
