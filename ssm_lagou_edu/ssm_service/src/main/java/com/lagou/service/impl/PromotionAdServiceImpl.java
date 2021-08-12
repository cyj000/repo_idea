package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.vo.PromotionAdVo;
import com.lagou.mapper.PromotionAdMapper;
import com.lagou.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: PromotionAdServiceImpl
 * @Author: CYJ
 * @Date: 2021-08-09 15:37:22
 * @Description:
 */
@Service
public class PromotionAdServiceImpl implements PromotionAdService {
    @Autowired
    private PromotionAdMapper adMapper;
    @Override
    public PageInfo findAllAdByPage(PromotionAdVo adVo) {
        PageHelper.startPage(adVo.getCurrentPage(),adVo.getPageSize());
        List<PromotionAd> allAd = adMapper.findAllPromotionAdByPage();
        PageInfo<PromotionAd> adPageInfo = new PageInfo<>(allAd);
        return adPageInfo;
    }
    @Override
    public void savePromotionAd(PromotionAd promotionAd) {
        adMapper.savePromotionAd(promotionAd);
    }
    @Override
    public void updatePromotionAd(PromotionAd promotionAd) {
        adMapper.updatePromotionAd(promotionAd);
    }

    @Override
    public PromotionAd findPromotionAdById(int id) {
        PromotionAd promotionAd = adMapper.findPromotionAdById(id);
        return promotionAd;
    }

    @Override
    public void updatePromotionAdStatus(int id,int status) {
        Date date=new Date();
        PromotionAd promotionAd=new PromotionAd();
        promotionAd.setUpdateTime(date);
        promotionAd.setId(id);
        promotionAd.setStatus(status);
        adMapper.updatePromotionAdStatus(promotionAd);
    }

}

