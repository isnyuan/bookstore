package com.bookstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能描述: 省市区信息
 * @Author: lihuizong
 * @Date: 2020/9/22 11:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AreaInfo {

    /**
     * 地区编号
     */
    private String areaCode;

    /**
     * 地区名字
     */
    private String areaName;

    /**
     * 父级编号
     */
    private String parentCode;

}
