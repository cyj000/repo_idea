package com.lagou.mapper;

import com.lagou.domain.ResourceCategory;

import java.util.List;

/**
 * @ClassName: ResourceCategoryMapper
 * @Author: CYJ
 * @Date: 2021-08-11 15:17:02
 * @Description:
 */

public interface ResourceCategoryMapper {
    public List<ResourceCategory> findAllCategory();
}
