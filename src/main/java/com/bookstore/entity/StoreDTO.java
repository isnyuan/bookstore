package com.bookstore.entity;

/**
 * 作者：李丹涛
 * 时间：2020/04/13晚上23：13分
 * 功能：用于用户form传递多参数使用的dto实体类信息
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreDTO {

    /**
     * 最后一次修改者编号
     */
    private String lastUpdateUser;

    /**
     * 门店编号列表
     */
    private List<String> storeCodeList;

}
