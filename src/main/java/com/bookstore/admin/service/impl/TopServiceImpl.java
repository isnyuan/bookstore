package com.bookstore.admin.service.impl;

import com.bookstore.admin.dao.TopDao;
import com.bookstore.admin.entity.TopInfo;
import com.bookstore.admin.service.TopService;
import com.bookstore.utils.Response;
import com.bookstore.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopServiceImpl implements TopService {

    @Autowired
    private TopDao topDao;

    @Override
    public Response getTop() {
        String userCode = SecurityUtils.getCurrentUserCode();
        TopInfo topInfo = topDao.getTop(userCode);
        // 角色店长 返回门店编号
        if (topInfo.getRole().equals("1")) {
            TopInfo storeCode = topDao.getStoreCode(userCode);
            topInfo.setStoreCode(storeCode.getStoreCode());
        }
        if(topInfo==null){
            return Response.error("未查询到相关顶部栏信息！");
        }else {
            return Response.success("查询成功！",topInfo);
        }
    }

}
