package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Resource;
import com.lagou.domain.vo.ResourceVo;

/**
 * @ClassName: ResourceService
 * @Author: CYJ
 * @Date: 2021-08-11 15:05:42
 * @Description:
 */

public interface ResourceService {
    public PageInfo<Resource> findAllResource(ResourceVo resourceVo);
}
