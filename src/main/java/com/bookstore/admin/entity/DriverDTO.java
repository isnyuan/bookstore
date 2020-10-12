package com.bookstore.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 作者：李丹涛
 * 时间：2020/04/13凌晨01：50
 * 功能：用于接受前端form请求的多参数
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverDTO {

    /**
     * 最后一次修改者编号
     */
    private String lastUpdateUser;

    /**
     * 司机编号列表
     */
    private List<String> driverCodeList;

}
