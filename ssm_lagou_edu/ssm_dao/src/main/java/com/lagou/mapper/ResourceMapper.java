package com.lagou.mapper;

import com.lagou.domain.Resource;
import com.lagou.domain.vo.ResourceVo;

import java.util.List;

/**
 * @ClassName: ResourceMapper
 * @Author: CYJ
 * @Date: 2021-08-11 14:58:42
 * @Description:
 */

public interface ResourceMapper {
    public List<Resource> findAllResource(ResourceVo resourceVo);
}
