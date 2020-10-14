package com.bookstore.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能描述: 验证码实体类
 * @Author: lihuizong
 * @Date: 2020/10/14 19:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageCode {

    /**
     * 图片 base64
     */
    private String image;
    /**
     * 随机数
     */
    private String code;


}
