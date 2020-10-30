package com.bookstore.utils;

/**
 * 作者：李丹涛
 * 时间：2020/04/16下午14：06分
 * 功能：对象存储
 */

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpMethodName;
import com.qcloud.cos.model.GeneratePresignedUrlRequest;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;

import java.io.File;
import java.net.URL;
import java.util.Date;

public class TencentCosUtil {

    // 指定要上传到的存储桶, 此处填写的存储桶名称
    private final static String BUCKET_NAME = "lidantao-1300355498";
    // secretId
    private final static String SECRET_ID = "AKIDZnkPvI04XkiSuH70xlIaBVXR4RZFuvqZ";
    // secretKey
    private final static String SECRET_KEY = "f6A7anmU6VaniV2KK3oKI0g5DPLZT7PQ";

    // 1 初始化用户身份信息(secretId, secretKey，可在腾讯云后台中的API密钥管理中查看！
    private static COSCredentials cred = new BasicCOSCredentials(SECRET_ID, SECRET_KEY);

    // 2 ClientConfig 类为配置信息类, 设置bucket的区域
    private static ClientConfig clientConfig = new ClientConfig(new Region("ap-guangzhou"));


    /**
     * 作者：李丹涛
     * 时间：2020/04/16晚上21：49分
     * 功能：图片上传
     */
    public static String upload(File localFile, String key) {
        // 生成cos客户端
        COSClient cosClient = new COSClient(cred, clientConfig);
        //文件上传
        PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKET_NAME, key, localFile);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        //获取上传文件的url
        GeneratePresignedUrlRequest req = new GeneratePresignedUrlRequest(BUCKET_NAME, key, HttpMethodName.GET);
        // 设置签名过期时间(可选), 若未进行设置, 则默认使用 ClientConfig 中的签名过期时间(1小时)
        // 这里设置签名在半个小时后过期
        Date expirationDate = new Date(System.currentTimeMillis() + 30L * 60L * 1000L);
        req.setExpiration(expirationDate);
        URL url = cosClient.generatePresignedUrl(req);
        // 关闭客户端(关闭后台线程)
        cosClient.shutdown();
        return url.toString();
    }

}
