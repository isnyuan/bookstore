package com.bookstore.app.dao;

import com.bookstore.app.entity.ARegisterInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 作者：李丹涛
 * 时间：2020/04/16下午17：14分
 * 功能：注册Dao接口
 */

@Mapper
public interface ARegisterDao {

    /**
     * 作者：李丹涛
     * 时间：2020/04/15分下午14：21分
     * 功能：检查修改得邀请码是否存在
     */
    int isExitInviteCode(@Param("inviteCode") String inviteCode);


    /**
     * 作者：李丹涛
     * 时间：2020/04/10晚上22：09分
     * 功能：查询账号或手机是否存在，registerInfo用户信息
     */
    int checkUser(ARegisterInfo registerInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/16下午17：14分
     * 功能：新增用户
     * registerInfo：客户实体类信息
     */
    int addUser(ARegisterInfo registerInfo);


    /**
     * 作者：李丹涛
     * 时间：2020/04/16下午17：14分
     * 功能：注册接口，registerInfo注册用户信息实体类
     */
    int clientRegister(ARegisterInfo registerInfo);

}
