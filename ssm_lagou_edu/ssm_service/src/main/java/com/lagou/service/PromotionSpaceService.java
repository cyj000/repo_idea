package com.lagou.service;

import com.lagou.domain.PromotionSpace;

import java.util.List;

/**
 * @ClassName: PromotionSpaceService
 * @Author: CYJ
 * @Date: 2021-08-09 14:59:49
 * @Description:
 */
public interface PromotionSpaceService {
    /*
    获取所有的广告位
    */
    public List<PromotionSpace> findAllPromotionSpace();

    void savePromotionSpace(PromotionSpace promotionSpace);

    void updatePromotionSpace(PromotionSpace promotionSpace);

    PromotionSpace findPromotionSpaceById(int id);
}
