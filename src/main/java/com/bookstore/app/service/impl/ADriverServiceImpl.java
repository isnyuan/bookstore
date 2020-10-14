package com.bookstore.app.service.impl;

import com.bookstore.app.dao.ADriverDao;
import com.bookstore.app.entity.ADriverInfo;
import com.bookstore.app.service.ADriverService;
import com.bookstore.utils.Response;
import com.bookstore.utils.SecurityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ADriverServiceImpl implements ADriverService {

    //注入DriverDao接口
    @Resource
    private ADriverDao aDriverDao;

    /**
     * 作者：李丹涛
     * 时间：2020/04/15下午15：09分
     * 功能：查询司机负责门店，店长的相关信息，
     */
    public Response findDriverStore() {
        String userCode = SecurityUtils.getCurrentUserCode();
        System.out.println(userCode);
        List<ADriverInfo> list = aDriverDao.findDriverStore(userCode);
        if (list.size() == 0) {
            return Response.error("未查询到相关店长信息！");
        } else {
            for (ADriverInfo driverInfo:list) {
                String address = driverInfo.getProvinceName()
                        + driverInfo.getCityName()
                        + driverInfo.getAreaName()
                        + driverInfo.getAddress();
                driverInfo.setAddress(address);
            }
            return Response.success("查询成功！",list);
        }
    }
}
