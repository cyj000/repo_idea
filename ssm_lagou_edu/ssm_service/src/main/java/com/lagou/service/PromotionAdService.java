package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.vo.PromotionAdVo;

/**
 * @ClassName: PromotionAdService
 * @Author: CYJ
 * @Date: 2021-08-09 15:37:06
 * @Description:
 */

public interface PromotionAdService {
            /*
        分页获取所有的广告列表
        */
    public PageInfo findAllAdByPage(PromotionAdVo adVo);

    void savePromotionAd(PromotionAd promotionAd);

    void updatePromotionAd(PromotionAd promotionAd);

            /*
        回显广告信息
        */
    PromotionAd findPromotionAdById(int id);

    void updatePromotionAdStatus(int id,int status);
}
