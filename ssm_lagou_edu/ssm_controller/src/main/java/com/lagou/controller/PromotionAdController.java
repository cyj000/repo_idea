package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Constant;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.vo.PromotionAdVo;
import com.lagou.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: PromotionAdController
 * @Author: CYJ
 * @Date: 2021-08-09 15:37:55
 * @Description:
 */
@RestController
@RequestMapping("/PromotionAd")
public class PromotionAdController {
    @Autowired
    private PromotionAdService adService;
    /*
    分页查询所有广告信息
    */
    @RequestMapping("/findAllPromotionAd")
    public ResponseResult findAllAdByPage(PromotionAdVo adVo) {
        PageInfo allAdByPage = adService.findAllAdByPage(adVo);
        return ResponseResult.success(allAdByPage);
    }

        /*
    新增或更新广位置
    */
    @RequestMapping("/saveOrUpdatePromotionAd")
    public ResponseResult saveOrUpdatePromotionAd(@RequestBody PromotionAd promotionAd) {
        try {
            Date date = new Date();
            if (promotionAd.getId() == null) {
                promotionAd.setCreateTime(date);
                promotionAd.setUpdateTime(date);
                adService.savePromotionAd(promotionAd);
            } else {
                promotionAd.setUpdateTime(date);
                adService.updatePromotionAd(promotionAd);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseResult.success();
    }

    /**
     * 根据id回显 广告数据
     * */
    @RequestMapping("/findPromotionAdById")
    public ResponseResult findPromotionAdById(@RequestParam int id){
        try {
            PromotionAd promotionAd = adService.findPromotionAdById(id);
            return ResponseResult.success(promotionAd);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    /*
        文件上传
        */
    @RequestMapping("/PromotionAdUpload")
    public ResponseResult fileUpload(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws IOException {
        try {
            //1.判断文件是否为空
            if (file.isEmpty()) {
                throw new RuntimeException();
            }
            //2.获取项目部署路径
            String realPath = request.getServletContext().getRealPath("/");
            String webappsPath = realPath.substring(0,
                    realPath.indexOf("ssm"));
            //3.获取原文件名
            String fileName = file.getOriginalFilename();
            //4.新文件名
            String newFileName = System.currentTimeMillis() +
                    fileName.substring(fileName.lastIndexOf("."));
            //5.上传文件
            String uploadPath = webappsPath + "upload\\";
            File filePath = new File(uploadPath, newFileName);
            //如果目录不存在就创建目录
            if (!filePath.getParentFile().exists()) {
                filePath.getParentFile().mkdirs();
                System.out.println("创建目录: " + filePath);
            }
            file.transferTo(filePath);
            //6.将文件名和文件路径返回
            Map<String, String> map = new HashMap<>();
            map.put("fileName", newFileName);
            map.put("filePath", Constant.LOCAL_URL + newFileName);
            return ResponseResult.success(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 广告上下限
     */
    @RequestMapping(value = "updatePromotionAdStatus")
    public ResponseResult updatePromotionAdStatus(@RequestParam Integer id,@RequestParam Integer status){
        try{
            if(status==1){
                adService.updatePromotionAdStatus(id,status);
            }else{
                adService.updatePromotionAdStatus(id,0);
            }

            Map<String,Integer> map=new HashMap<>();
            map.put("status",status);
            return  ResponseResult.success(map);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

