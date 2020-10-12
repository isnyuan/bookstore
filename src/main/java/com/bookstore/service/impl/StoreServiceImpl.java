package com.bookstore.service.impl;

import com.bookstore.dao.StoreDao;
import com.bookstore.entity.StoreDTO;
import com.bookstore.entity.StoreInfo;
import com.bookstore.page.PageUtils;
import com.bookstore.service.StoreService;
import com.bookstore.utils.RandomCode;
import com.bookstore.utils.Response;
import com.bookstore.utils.SecurityUtils;
import com.bookstore.utils.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    //注入StoreDao接口
    @Resource
    private StoreDao storeDao;

    /**
     * 店长编号:1
     */
    private static final String ROLE = "1";

    /**
     * 作者：李丹涛
     * 时间：2020/04/13晚上22：29分
     * 功能：新增门店信息接口
     * storeInfo：门店实体类信息
     */
    @Override
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response addStore(StoreInfo storeInfo){
        //设置创建者和修改者
        storeInfo.setCreateUser(SecurityUtils.getCurrentUserCode());
        storeInfo.setLastUpdateUser(SecurityUtils.getCurrentUserCode());
        //随机生成门店编号,返回数据:时间戳+3为随机数
        storeInfo.setStoreCode(StringUtil.getCommonCode(3));
        //删除标记：未删除0
        storeInfo.setIsDelete("0");
        //随机生成6位邀请码
        storeInfo.setInviteCode(new RandomCode().genRandomNum());
        //检查填写的店长编号是否已在用户表（行走书店是否有这个人），无相关对应则需重新填写，不可无中生有
        int userIsExist = storeDao.checkUserCode(storeInfo.getUserCode());
        if (userIsExist == 0) {
            return Response.error("新增失败，此店长编号在用户表不存在，请先去注册！");
        }
        //一次性提取全部的店长校验信息,提高效率.逐个校验是否重复,给用户飞一般的感觉
        List<StoreInfo> storeInfoList = storeDao.checkStoreInfo();
        for(StoreInfo storeInfo1:storeInfoList){
            if(storeInfo1.getPhone().equals(storeInfo.getPhone())){
                return Response.error("新增门店失败，此手机号已关联其他店铺，请绑定其他号码！");
            }
            if(storeInfo1.getStoreName().equals(storeInfo.getStoreName())){
                return Response.error("新增门店失败，此店名已存在，请更换其他店名！");
            }
            if(storeInfo1.getUserCode().equals(storeInfo.getUserCode())){
                return Response.error("新增门店失败，此用户已开通其他店铺！");
            }
            if(storeInfo1.getBusinessCode().equals(storeInfo.getBusinessCode())){
                return Response.error("新增门店失败，此营业执照编码已存在！");
            }
        }
        int flag = storeDao.addStore(storeInfo);
        if (flag > 0) {
            return Response.success("新增门店成功！");
        } else {
            //新增失败，事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("新增门店信息有错！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/13晚上22：33分
     * 功能：查询门店信息详情接口
     * storeCode：门店编号
     */
    @Override
    public Response findStore(String storeCode) {
        StoreInfo storeInfo = storeDao.findStore(storeCode);
        if (storeInfo != null) {
            return Response.success("查询门店信息详情成功！", storeInfo);
        } else {
            return Response.error("未查询到相关门店信息");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/13晚上22：36分
     * 功能：分页查询门店信息
     * storeInfo：门店实体类信息
     */
    @Override
    public Response listStore(StoreInfo storeInfo) {
        //获取当前登录用户编号
        storeInfo.setCurrentUserCode(SecurityUtils.getCurrentUserCode());
        List<StoreInfo> list = storeDao.listStoreByPage(storeInfo);
        if (list.size() == 0) {
            return Response.error("未查询到相关门店信息！");
        } else {
            return Response.success("查询成功！", PageUtils.getPageInfo(list));
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/13晚上22：39分
     * 功能：修改门店信息接口
     * storeInfo：门店实体类信息
     */
    @Override
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response updateStore(StoreInfo storeInfo) {
        //设置当前修改者编码
        storeInfo.setLastUpdateUser(SecurityUtils.getCurrentUserCode());
        //检查此时修改的店长编号是否已在用户表（行走书店是否有这个人），无相关对应则需重新填写，不可无中生有
        int userIsExist = storeDao.checkUserCode(storeInfo.getUserCode());
        if (userIsExist == 0) {
            return Response.error("新增失败，此店长编号在用户表不存在，请先去注册！");
        }
        //一次性提取全部的店长校验信息,提高效率.逐个校验是否重复,给用户飞一般的感觉
        List<StoreInfo> storeInfoList = storeDao.checkStoreInfoByUpdate(storeInfo.getStoreCode());
        for(StoreInfo storeInfo1:storeInfoList){
            if(storeInfo1.getPhone().equals(storeInfo.getPhone())){
                return Response.error("修改门店信息失败，此手机号已关联其他店铺，请绑定其他号码！");
            }
            if(storeInfo1.getStoreName().equals(storeInfo.getStoreName())){
                return Response.error("修改门店信息失败，此店名已存在，请更换其他店名！");
            }
            if(storeInfo1.getUserCode().equals(storeInfo.getUserCode())){
                return Response.error("修改门店信息失败，此用户已开通其他店铺！");
            }
            if(storeInfo1.getBusinessCode().equals(storeInfo.getBusinessCode())){
                return Response.error("修改门店信息失败，此营业执照编码已存在！");
            }
        }
        int count = storeDao.updateStore(storeInfo);
        if (count > 0) {
            return Response.success("修改门店信息成功！");
        } else {
            //修改失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("修改门店信息有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/13晚上22：42分
     * 功能：删除门店信息接口
     * storeDTO：用于用户传递多参数使用的实体类信息
     */
    @Override
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response deleteStore(StoreDTO storeDTO){
        //设置当前修改者编码
        storeDTO.setLastUpdateUser(SecurityUtils.getCurrentUserCode());
        int count = storeDao.deleteStore(storeDTO);
        if (count > 0) {
            return Response.success("删除成功！");
        } else {
            //删除失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("删除门店信息操作有误！");
        }
    }
}
