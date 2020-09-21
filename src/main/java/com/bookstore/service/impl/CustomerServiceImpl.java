package com.bookstore.service.impl;

import com.bookstore.dao.CustomerDao;
import com.bookstore.entity.CustomerInfo;
import com.bookstore.service.CustomerService;
import com.bookstore.utils.Response;
import com.bookstore.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    /**
     * 用户角色（店长编号为1）
     */
    private static final String ROLE = "1";


    @Override
    public Response listCustomer(CustomerInfo customerInfo) {
        if(customerInfo.getRole().equals(ROLE)){
            //角色为店长，只查询自己门店下的客户
            customerInfo.setUserCode(SecurityUtils.getCurrentUserCode());
            System.out.println(SecurityUtils.getCurrentUserCode());
            List<CustomerInfo> list = customerDao.listCustomerStoreByPage(customerInfo);
            if (list.size() == 0) {
                return Response.error("未查询到相关客户列表信息！");
            } else {
                //return Response.success("查询成功！", getPageInfo(list));
                return Response.success("查询成功！", list);
            }
        }else {
            //角色为管理员查全部客户
            List<CustomerInfo> list = customerDao.listCustomerByPage(customerInfo);
            if (list.size() == 0) {
                return Response.error("未查询到相关客户列表信息！");
            } else {
                //return Response.success("查询成功！", getPageInfo(list));
                return Response.success("查询成功！", list);
            }
        }
    }
}
