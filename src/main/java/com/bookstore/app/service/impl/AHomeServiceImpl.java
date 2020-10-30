package com.bookstore.app.service.impl;

import com.bookstore.app.dao.AHomeDao;
import com.bookstore.app.entity.AHomeInfo;
import com.bookstore.app.service.AHomeService;
import com.bookstore.utils.Response;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者：李丹涛
 * 时间：2020/04/14
 * 功能：首页轮播图service类、热门商品service类
 */

@Service
public class AHomeServiceImpl implements AHomeService {



    //注入HomeDao接口
    @Resource
    private AHomeDao aHomeDao;

    /**
     * 轮播图状态
     * START:启用0、
     * STOP:禁用1
     */
    private static final String START = "0";
    private static final String STOP = "1";

    /**
     * 作者：李丹涛
     * 时间：2020/04/14
     * 功能：查询首页轮播图接口
     */
    public Response listRotate() {
        //查询启用状态的、过期时间在sql体现
        String rotateActive = START;
        List<AHomeInfo> list = aHomeDao.listRotate(rotateActive);
        if (list.size() == 0) {
            return Response.error("暂未查到轮播图信息！");
        } else {
            return Response.success("查询成功！", list);
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/14晚上19：54
     * 功能：分页查询热门商品接口
     */
    public Response listHotGoods(){
        //查询需要展示的数量
        AHomeInfo hotGoodsInfo1 = aHomeDao.findHotGoodsShowNum();
        //查询热门商品列表信息
        List<AHomeInfo> list = aHomeDao.listHotGoods();
        if (list.size() == 0) {
            return Response.error("暂未查到热门商品信息！");
        } else {
            //新的热门商品表（数量设置后）
            List<AHomeInfo> newHotGoodsInfoList = new ArrayList<>();
            //展示数量叠加
            for (int i = 0; i < hotGoodsInfo1.getHotGoodsShowNum(); i++) {
                if(i >= list.size()){
                    break;
                }
                newHotGoodsInfoList.add(list.get(i));
            }
            return Response.success("查询成功！", newHotGoodsInfoList);
        }
    }


}
