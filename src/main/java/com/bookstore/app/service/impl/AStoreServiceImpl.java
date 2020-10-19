package com.bookstore.app.service.impl;


import com.bookstore.app.dao.AStoreDao;
import com.bookstore.app.entity.AStoreInfo;
import com.bookstore.app.service.AStoreService;
import com.bookstore.utils.Response;
import com.bookstore.utils.SecurityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 作者：李丹涛
 * 时间：2020/04/15分下午14：16分
 * 功能：门店下司机信息StoreService类
 */

@Service
public class AStoreServiceImpl implements AStoreService {

    //注入StoreDao接口
    @Resource
    private AStoreDao aStoreDao;

    /**
     * 作者：李丹涛
     * 时间：2020/04/15下午14：44分
     * 功能：店长个人信息之查询司机信息
     */
    @Override
    public Response listManangerDriver() {
        //获取当前登录用户编号
        String userCode = SecurityUtils.getCurrentUserCode();
        List<AStoreInfo> list = aStoreDao.listManangerDriver(userCode);
        if (list.size() == 0) {
            return Response.error("未查询到司机相关信息！");
        } else {
            return Response.success("查询司机信息详情成功！", list);
        }
    }

}
