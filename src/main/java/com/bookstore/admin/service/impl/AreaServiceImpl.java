package com.bookstore.admin.service.impl;

import com.bookstore.admin.dao.AreaDao;
import com.bookstore.admin.entity.AreaInfo;
import com.bookstore.admin.service.AreaService;
import com.bookstore.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    /**
     * 作者：李丹涛
     * 时间：2020/04/13晚上22：27分
     * 功能：查询省市区下拉框接口
     * areaCode：区域编号（省传0，市传省编号，区传市编号）
     */
    @Override
    public Response listArea(String parentCode) {
        List<AreaInfo> list = areaDao.listArea(parentCode);
        if (list.size() == 0) {
            return Response.error("未查询到相关地区信息！");
        } else {
            return Response.success("查询成功！", list);
        }
    }

}
