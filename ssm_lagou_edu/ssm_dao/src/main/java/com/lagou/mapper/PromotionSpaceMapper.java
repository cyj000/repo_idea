package com.lagou.mapper;

import com.lagou.domain.PromotionSpace;

import java.util.List;

/**
 * @ClassName: PromotionSpaceMapper
 * @Author: CYJ
 * @Date: 2021-08-09 14:55:58
 * @Description:
 */
public interface PromotionSpaceMapper {
    /**
    *获取所有的广告位
    **/
    public List<PromotionSpace> findAllPromotionSpace();
        /**
         *添加广告位
         * */
    public void savePromotionSpace(PromotionSpace promotionSpace);
        /**
         * 修改广告位
         * */
    public void updatePromotionSpace(PromotionSpace promotionSpace);
    /**
     * 根据id 查询广告位信息
     * */
    public PromotionSpace findPromotionSpaceById(int id);
}

