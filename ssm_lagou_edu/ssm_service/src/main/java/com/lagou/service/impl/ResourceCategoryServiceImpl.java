package com.lagou.service.impl;

import com.lagou.domain.ResourceCategory;
import com.lagou.mapper.ResourceCategoryMapper;
import com.lagou.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: ResourceCategoryServiceImpl
 * @Author: CYJ
 * @Date: 2021-08-11 15:19:03
 * @Description:
 */
@Service
public class ResourceCategoryServiceImpl implements ResourceCategoryService {

    @Autowired
    ResourceCategoryMapper resourceCategoryMapper;
    @Override
    public List<ResourceCategory> findAllCategory() {
        List<ResourceCategory> allCategory = resourceCategoryMapper.findAllCategory();
        return allCategory;
    }
}
