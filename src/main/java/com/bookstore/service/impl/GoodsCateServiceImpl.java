package com.bookstore.service.impl;

import com.bookstore.dao.GoodsCateDao;
import com.bookstore.entity.GoodsCateInfo;
import com.bookstore.service.GoodsCateService;
import com.bookstore.utils.Response;
import com.bookstore.utils.SecurityUtils;
import com.bookstore.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsCateServiceImpl implements GoodsCateService {

    @Autowired
    private GoodsCateDao goodsCateDao;

    @Override
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response addGoodsCate(GoodsCateInfo goodsCateInfo) {
        //检查添加此商品分类名称是否存在
        int count = goodsCateDao.checkGoodsCate(goodsCateInfo);
        if (count > 0) {
            return Response.error("此商品分类已存在，请勿重复添加！");
        } else {
            //随机生成商品分类编号,返回数据:时间戳+3为随机数
            goodsCateInfo.setGoodsCateCode(StringUtil.getCommonCode(3));
            //删除标记：未删除0
            goodsCateInfo.setIsDelete("0");
            //设置创建者和修改者
            goodsCateInfo.setCreateUser(SecurityUtils.getCurrentUserCode());
            goodsCateInfo.setLastUpdateUser(SecurityUtils.getCurrentUserCode());
            int flag = goodsCateDao.addGoodsCate(goodsCateInfo);
            if (flag > 0) {
                return Response.success("新增商品分类成功！");
            } else {
                //新增失败，事务回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Response.error("新增商品分类信息有误，请重新填写！");
            }
        }
    }

    @Override
    public Response findGoodsCate(String goodsCateCode) {
        GoodsCateInfo goodsCateInfo = goodsCateDao.findGoodsCate(goodsCateCode);
        if (goodsCateInfo == null) {
            return Response.error("未查询到相关商品分类信息！");
        } else {
            return Response.success("查询成功!", goodsCateInfo);
        }
    }

    @Override
    public Response listGoodsCate() {
        //查询一级商品分类
        List<GoodsCateInfo> list1 = goodsCateDao.firstListGoodsCate();
        //查询二级商品分类
        List<GoodsCateInfo> list2 = goodsCateDao.secondListGoodsCate();

        List<Map> mapList = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            //new一个map装每个分类下的分类详情信息
            Map map = new HashMap();
            map.put("goodsCateCode",list1.get(i).getGoodsCateCode());
            map.put("goodsCateName",list1.get(i).getGoodsCateName());
            map.put("cateParentCode",list1.get(i).getCateParentCode());
            map.put("version",list1.get(i).getVersion());
            //new一个list存放所有关联的二级分类
            List<Map> list = new ArrayList<>();
            for (int i1 = 0; i1 < list2.size(); i1++) {
                if(list2.get(i1).getCateParentCode().equals(list1.get(i).getGoodsCateCode())) {
                    //new一个map存放二级分类详情信息
                    Map map1 = new HashMap();
                    map1.put("goodsCateCode", list2.get(i1).getGoodsCateCode());
                    map1.put("goodsCateName", list2.get(i1).getGoodsCateName());
                    map1.put("cateParentCode", list2.get(i1).getCateParentCode());
                    map1.put("version", list2.get(i1).getVersion());
                    list.add(map1);
                }
            }
            if (list.size() == 0) {
                map.put("secondList", "");
            } else {
                map.put("secondList", list);
            }
            mapList.add(map);
        }
        if (mapList.size() == 0) {
            return Response.error("未查询到相关商品分类列表信息1");
        } else {
            return Response.success("查询成功!", mapList);
        }
    }

    @Override
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response updateGoodsCate(GoodsCateInfo goodsCateInfo) {
        //设置当前修改者编码
        goodsCateInfo.setLastUpdateUser(SecurityUtils.getCurrentUserCode());
        int count = goodsCateDao.updateGoodsCate(goodsCateInfo);
        if (count > 0) {
            return Response.success("修改成功！");
        } else {
            //修改失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("修改商品分类操作有误！");
        }
    }

    @Override
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response deleteGoodsCate(GoodsCateInfo goodsCateInfo) {
        goodsCateInfo.setLastUpdateUser(SecurityUtils.getCurrentUserCode());
        //查询是否为一级分类
        int parentCode = goodsCateDao.checkParentCode(goodsCateInfo.getGoodsCateCode());
        //为一级分类,加以判断是否存在商品或二级分类
        if( parentCode > 0){
            //检查是否存在二级商品分类
            int firstCateIsExist = goodsCateDao.checkFirstCate(goodsCateInfo.getGoodsCateCode());
            if (firstCateIsExist > 0) {
                return Response.error("该商品分类存在着二级分类,不允许删除");
            }
            //该分类下是否存在着商品
            int isExistGoods = goodsCateDao.checkGoods(goodsCateInfo.getGoodsCateCode());
            if (isExistGoods > 0) {
                return Response.error("该商品分类下有商品,不允许删除");
            }
        }
        int count = goodsCateDao.deleteGoodsCate(goodsCateInfo);
        if (count > 0) {
            return Response.success("删除成功！");
        } else {
            //删除失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("删除商品分类操作有误！");
        }
    }
}
