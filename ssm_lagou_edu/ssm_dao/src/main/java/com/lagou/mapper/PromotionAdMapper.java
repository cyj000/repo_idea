package com.lagou.mapper;

import com.lagou.domain.PromotionAd;

import java.util.List;

/**
 * @ClassName: PromotionAdMapper
 * @Author: CYJ
 * @Date: 2021-08-09 15:31:07
 * @Description:
 */

public interface PromotionAdMapper {
            /*
        分页获取所有的广告列表
        */
    public List<PromotionAd> findAllPromotionAdByPage();

    void savePromotionAd(PromotionAd promotionAd);

    void updatePromotionAd(PromotionAd promotionAd);

    /**
     * 根据id查询广告信息
     * */
    PromotionAd findPromotionAdById(int id);

    void updatePromotionAdStatus(PromotionAd promotionAd);
}
