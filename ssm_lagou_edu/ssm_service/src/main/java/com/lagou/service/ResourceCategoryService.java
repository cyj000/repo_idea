package com.lagou.service;

import com.lagou.domain.ResourceCategory;

import java.util.List;

/**
 * @ClassName: ResourceCategoryService
 * @Author: CYJ
 * @Date: 2021-08-11 15:18:53
 * @Description:
 */

public interface ResourceCategoryService {
    public List<ResourceCategory> findAllCategory();
}
