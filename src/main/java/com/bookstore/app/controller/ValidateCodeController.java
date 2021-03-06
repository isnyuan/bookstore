package com.bookstore.app.controller;

import com.bookstore.app.entity.ImageCode;
import com.bookstore.utils.ImageCodeGeneratorUtil;
import com.bookstore.utils.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;

/**
 * 功能描述: 获取验证码
 * @Author: lihuizong
 * @Date: 2020/10/14 19:22
 */
@RestController
public class ValidateCodeController {

    @PostMapping("/code/image")
    public Response createCode(HttpServletRequest request) {
        try {
            // 获取验证码
            ImageCode code = ImageCodeGeneratorUtil.createCode();
            //System.out.println(code);
            HashMap<String, String> data = new HashMap<>();
            data.put("imageCode", code.getCode());
            data.put("image", code.getImage());
            request.getSession().setAttribute("imageCode", code.getCode());
            System.out.println(request.getSession().getAttribute("imageCode"));
            System.out.println(code.getImage());
            //写给response 响应
            //ImageIO.write(code.getImage(),"JPEG", response.getOutputStream());
            return Response.success("获取验证码成功！", data);
        } catch (IOException e) {
            return Response.servers("获取验证码失败！");
        }
    }

}
