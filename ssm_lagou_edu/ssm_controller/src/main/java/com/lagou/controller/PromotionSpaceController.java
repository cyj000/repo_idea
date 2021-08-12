package com.lagou.controller;

import com.lagou.domain.PromotionSpace;
import com.lagou.domain.ResponseResult;
import com.lagou.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: PromotionSpaceController
 * @Author: CYJ
 * @Date: 2021-08-09 15:00:30
 * @Description:
 */
@RestController
@RequestMapping("/PromotionSpace")
public class PromotionSpaceController {
    @Autowired
    private PromotionSpaceService promotionSpaceService;
    /*
    查询所有广告位列表
    */
    @RequestMapping("/findAllPromotionSpace")
    public ResponseResult findAllPromotionSpace(){
        List<PromotionSpace> allPromotionSpace = promotionSpaceService.findAllPromotionSpace();
        return ResponseResult.success(allPromotionSpace);
    }

    /*
添加&修改广告位
*/
    @RequestMapping("/saveOrUpdatePromotionSpace")
    public ResponseResult savePromotionSpace(@RequestBody PromotionSpace
                                                     promotionSpace){
        try {
            if(promotionSpace.getId() == null){
            //新增
                promotionSpaceService.savePromotionSpace(promotionSpace);

            }else{
            //修改
                promotionSpaceService.updatePromotionSpace(promotionSpace);
            }
                return ResponseResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据id查询 广告位信息
     * */
    @RequestMapping("/findPromotionSpaceById")
    public ResponseResult findPromotionSpaceById(@RequestParam int id){
        PromotionSpace promotionSpace = promotionSpaceService.findPromotionSpaceById(id);
        return ResponseResult.success(promotionSpace);
    }


}
