package com.bookstore.admin.service.impl;

import com.bookstore.admin.dao.GoodsDao;
import com.bookstore.admin.entity.GoodsCateInfo;
import com.bookstore.admin.entity.GoodsDTO;
import com.bookstore.admin.entity.GoodsInfo;
import com.bookstore.admin.service.GoodsService;
import com.bookstore.utils.Response;
import com.bookstore.utils.SecurityUtils;
import com.bookstore.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.*;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    /**
     * 作者：李丹涛
     * 商品状态（
     * NOSTOCK:已售完0、
     * SALLING:在售1、
     * DOWN:已下架2、
     * NOUP:未发布3
     */
    private static final String NOSTOCK = "0";
    private static final String SALLING = "1";
    private static final String DOWN = "2";
    private static final String NOUP = "3";

    /**
     * 作者：李丹涛
     * 时间：2020/04/11晚上22：49分
     * 功能：查询商品分类下拉框接口，goodsCateInfo为商品分类实体类信息
     */
    @Override
    public Response listGoodsCate(GoodsCateInfo goodsCateInfo) {
        List<GoodsCateInfo> goodsCateInfoList = goodsDao.listGoodsCate(goodsCateInfo);
        if (goodsCateInfoList.size() > 0) {
            return Response.success("查询商品分类下拉框信息成功！", goodsCateInfoList);
        } else {
            return Response.error("未查询到相关商品分类信息！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/11晚上22：49分
     * 功能：新增商品接口，goodsInfo商品信息
     */
    @Override
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response addGoods(GoodsInfo goodsInfo) {
        //检查isbn书号是否存在
        int isExit = goodsDao.checkIsbn(goodsInfo.getIsbn());
        if(isExit > 0){
            return Response.error("新增失败，此ISBN书号已存在，请重新填写！");
        }
        //设置创建者和修改者
        goodsInfo.setCreateUser(SecurityUtils.getCurrentUserCode());
        goodsInfo.setLastUpdateUser(SecurityUtils.getCurrentUserCode());
        //设置销售量、上架时间、浏览量为0
        goodsInfo.setGoodsSallNum("0");
        goodsInfo.setGoodsStartTime("0000-00-00-00 00:00:00");
        goodsInfo.setGoodsViewNum("0");
        //随机生成商品编号,返回数据:时间戳+3为随机数
        goodsInfo.setGoodsCode(StringUtil.getCommonCode(3));
        //库存为0，设置为已售完状态，一般新增不会有这种情况，此情况用于客户买完商品
        if("0".equals(goodsInfo.getGoodsStock())){
            goodsInfo.setGoodsActive(NOSTOCK);
        }else {
            //新增商品，默认为未发布状态，状态码为3（NOUP）
            goodsInfo.setGoodsActive(NOUP);
        }
        //删除标记：未删除0
        goodsInfo.setIsDelete("0");
        int count = goodsDao.addGoods(goodsInfo);
        if (count > 0) {
            return Response.success("新增商品信息成功！");
        } else {
            //新增失败，事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("新增信息有误，请重新填写！");
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/11晚上22：49分
     * 功能：查询商品详情接口，goodsCode商品编号
     */
    @Override
    public Response findGoods(String goodsCode) {
        GoodsInfo goodsInfo = goodsDao.findGoods(goodsCode);
        if (goodsInfo != null) {
            return Response.success("查询商品详情成功！", goodsInfo);
        } else {
            return Response.error("未查询到相关商品信息！");
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/11晚上22：49分
     * 功能：分页查询商品列表接口，goodsInfo商品信息
     */
    @Override
    public Response listGoods(GoodsInfo goodsInfo) {
        List<GoodsInfo> goodsInfoList = goodsDao.listGoodsByPage(goodsInfo);
        if (goodsInfoList.size() == 0) {
            return Response.error("未查询到相关商品列表信息！");
        } else {
            //return Response.success("查询成功！", getPageInfo(goodsInfoList));
            return Response.success("查询成功！", goodsInfoList);
        }
    }



    /**
     * 作者：李丹涛
     * 时间：2020/04/11晚上22：49分
     * 功能：修改商品接口，goodsInfo商品信息
     */
    @Override
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response updateGoods(GoodsInfo goodsInfo) {
        //设置当前修改者编码
        goodsInfo.setLastUpdateUser(SecurityUtils.getCurrentUserCode());
        int count = goodsDao.updateGoods(goodsInfo);
        if (count > 0) {
            return Response.success("修改成功！");
        } else {
            //修改失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("修改商品信息操作有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/11晚上22：49分
     * 功能：修改商品状态接口，goodsDTO用户form传的参数
     */
    @Override
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response updateGoodsActive(String goodsCode,String version, String goodsActive){
        List<String> goodsCodeList = Arrays.asList(goodsCode.split(","));
        List<String> versionList = Arrays.asList(version.split(","));
        //new一个goodsInfo用于传参
        GoodsInfo goodsInfo = new GoodsInfo();
        //设置当前修改者编码
        goodsInfo.setLastUpdateUser(SecurityUtils.getCurrentUserCode());
        //商品修改成什么状态
        goodsInfo.setGoodsActive(goodsActive);
        //new一个mapList给mybatis用
        List<Map> mapList = new ArrayList<>();
        for (int i = 0; i < goodsCodeList.size(); i++) {
            Map map = new HashMap();
            map.put("goodsCode",goodsCodeList.get(i));
            map.put("version",versionList.get(i));
            mapList.add(map);
        }
        goodsInfo.setMapList(mapList);
        int count = goodsDao.updateGoodsActive(goodsInfo);
        if (count > 0) {
            return Response.success("修改成功！");
        } else {
            //修改失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("修改商品状态操作有误！");
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/11晚上22：49分
     * 功能：删除商品接口，goodsDTO用户form传的参数
     */
    @Override
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response deleteGoods(GoodsDTO goodsDTO) {
        goodsDTO.setLastUpdateUser(SecurityUtils.getCurrentUserCode());
        //检查热门商品、轮播图是否有关联此删除商品
        int check1 = goodsDao.checkHotGoods(goodsDTO);
        int check2 = goodsDao.checkRotateGoods(goodsDTO);
        if (check1 > 0) {
            return Response.error("选择的商品与热门商品关联，无法删除！");
        }
        if (check2 > 0) {
            return Response.error("选择的商品与轮播图关联，无法删除！");
        }
        int delete = goodsDao.deleteGoods(goodsDTO);
        if (delete > 0) {
            return Response.success("删除商品成功！");
        } else {
            //删除失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("删除商品操作有误！");
        }
    }
}
