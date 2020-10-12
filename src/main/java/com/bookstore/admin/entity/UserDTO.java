package com.bookstore.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    //用户编号列表
    List<String> userCodeList;

    //用户编号
    private String userCode;

    //最后一次修改者的用户编号
    private String lastUpdateUser;
}
