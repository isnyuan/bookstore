package com.bookstore.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
