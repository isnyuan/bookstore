package com.bookstore.admin.controller;

import com.bookstore.admin.service.impl.TencentCosService;
import com.bookstore.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * 作者：李丹涛
 * 时间：2020/04/16中午10：32分
 * 功能：图片上传controller类
 */

@RestController
@RequestMapping("/pc/image")
public class TencentCosController {

    //日志
    private final Logger logger = LoggerFactory.getLogger(TencentCosController.class);

    @Resource
    private TencentCosService tencentCosService;

    @PostMapping("/uploadImage")
    public Response upload(@RequestParam("imageFile") MultipartFile multipartFile) throws Exception {
        try {
            return tencentCosService.upload(multipartFile);
        }catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("图片上传操作有误！");
        }
    }

}
