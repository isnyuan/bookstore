package com.bookstore.app.service.impl;

import com.bookstore.app.dao.AShopCarDao;
import com.bookstore.app.entity.AShopCarDTO;
import com.bookstore.app.entity.AShopCarInfo;
import com.bookstore.app.service.AShopCarService;
import com.bookstore.page.PageUtils;
import com.bookstore.utils.Response;
import com.bookstore.utils.SecurityUtils;
import com.bookstore.utils.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;

/**
 * 作者：李丹涛
 * 时间：2020/04/15中午11：37分
 * 功能：购物车Service类
 */

@Service
public class AShopCarServiceImpl implements AShopCarService {


    //注入ShopCarDao接口
    @Resource
    private AShopCarDao aShopCarDao;


    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午11：33分
     * 功能：新增购物车接口，ShopCarInfo为购物车实体类信息
     */
    @Override
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response addShopCar(AShopCarInfo shopCarInfo){
        //检查库存是否满足购买数量
        String stock = aShopCarDao.findGoodsStock(shopCarInfo);
        if(Integer.parseInt(stock) < Integer.parseInt(shopCarInfo.getGoodsCount())){
            return Response.error("商品库存不足");
        }
        //查看购物车是否存在此商品,是则增加数量即可
        //设置创建者和修改者
        shopCarInfo.setCreateUser(SecurityUtils.getCurrentUserCode());
        shopCarInfo.setLastUpdateUser(SecurityUtils.getCurrentUserCode());
        int isExit = aShopCarDao.checkShopCar(shopCarInfo);
        if (isExit > 0) {
            //存在了，则更新数量
            int update = aShopCarDao.updateShopCarCount(shopCarInfo);
            if(update>0){
                return Response.success("加入购物车成功！");
            } else {
                //新增失败，事务回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Response.error("加入购物车有误！");
            }
        } else {
            //随机生成商品编号,返回数据:时间戳+3为随机数
            shopCarInfo.setShopCarCode(StringUtil.getCommonCode(3));
            //删除标记：未删除0
            shopCarInfo.setIsDelete("0");
            int count = aShopCarDao.addShopCar(shopCarInfo);
            if (count > 0) {
                return Response.success("加入购物车成功！");
            } else {
                //新增失败，事务回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Response.error("加入购物车有误！");
            }
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午11：33分
     * 功能：查询购物车接口
     */
    @Override
    public Response listShopCar(){
        List<AShopCarInfo> list = aShopCarDao.listShopCarByPage();
        if (list != null) {
            return Response.success("查询购物车成功！", PageUtils.getPageInfo(list));
        } else {
            return Response.error("未查询购物车信息！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午11：33分
     * 功能：修改购物车接口，ShopCarInfo为购物车实体类信息
     */
    @Override
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response updateShopCar(AShopCarInfo shopCarInfo){
        //设置当前修改者编码
        shopCarInfo.setLastUpdateUser(SecurityUtils.getCurrentUserCode());
        int count = aShopCarDao.updateShopCar(shopCarInfo);
        if (count > 0) {
            return Response.success("修改成功！");
        } else {
            //修改失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("修改购物车操作有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午11：33分
     * 功能：删除购物车接口，shopCarDTO为接受前端多参信息
     */
    @Override
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response deleteShopCar(AShopCarDTO shopCarDTO){
        shopCarDTO.setLastUpdateUser(SecurityUtils.getCurrentUserCode());
        int delete = aShopCarDao.deleteShopCar(shopCarDTO);
        if (delete > 0) {
            return Response.success("删除成功！");
        } else {
            //删除失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("删除购物车操作有误！");
        }
    }
}
