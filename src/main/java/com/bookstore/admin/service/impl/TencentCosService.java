package com.bookstore.admin.service.impl;

import com.bookstore.utils.Response;
import com.bookstore.utils.TencentCosUtil;
import com.bookstore.utils.UUIDUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

//import static org.apache.rocketmq.common.UtilAll.deleteFile;

/**
 * 作者：李丹涛
 * 时间：2020/04/16中午10：34分
 * 功能：图片上传service类
 */

@Service
public class TencentCosService {


    /**
     * 作者：李丹涛
     * 时间：2020/04/16晚上22：42分
     * 功能：上传图片
     */
    public Response upload(MultipartFile multipartFile) throws Exception {
        //获取文件的名称
        String fileName = multipartFile.getOriginalFilename();
        //判断有无后缀，lastIndexOf返回最后一次出现的位置
        if (fileName.lastIndexOf(".") < 0){
            return Response.error("上传图片格式不正确");
        }
        //获取文件后缀
        String prefix = fileName.substring(fileName.lastIndexOf("."));
        //如果不是图片
        if (!".jpg".equalsIgnoreCase(prefix) && !".jpeg".equalsIgnoreCase(prefix) && !".svg".equalsIgnoreCase(prefix) && !".gif".equalsIgnoreCase(prefix) && !".png".equalsIgnoreCase(prefix)) {
            return Response.error("上传图片格式不正确");
        }
        //使用uuid作为文件名，防止生成的临时文件重复
        File excelFile = File.createTempFile("images" + UUIDUtils.getUUID(), prefix);
        //将Multifile转换成File
        multipartFile.transferTo(excelFile);
        //上传图片获取其url
        String url = TencentCosUtil.upload(excelFile, "lidantao/" + excelFile.getName());
        //删除临时文件
        //deleteFile(excelFile);
        Map<String,String> map = new HashMap<String, String>();
        map.put("imagePath",url);
        return Response.success("图片上传成功", map);
    }
}
