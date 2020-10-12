package com.bookstore.controller;

import com.bookstore.entity.CustomerInfo;
import com.bookstore.service.CustomerService;
import com.bookstore.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pc/customer")
@Validated
public class CustomerController {

    //日志
    private final Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Autowired
    private CustomerService customerService;

    @PostMapping("/listCustomer")
    public Response listCustomer(CustomerInfo customerInfo) {
        try {
            return customerService.listCustomer(customerInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询客户分页列表信息操作有误！");
        }
    }

}
