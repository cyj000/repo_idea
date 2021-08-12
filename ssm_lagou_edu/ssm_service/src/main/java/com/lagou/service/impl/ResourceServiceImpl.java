package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.domain.Resource;
import com.lagou.domain.vo.ResourceVo;
import com.lagou.mapper.ResourceMapper;
import com.lagou.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: ResourceImpl
 * @Author: CYJ
 * @Date: 2021-08-11 15:07:46
 * @Description:
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public PageInfo<Resource> findAllResource(ResourceVo resourceVo) {
        PageHelper.startPage(resourceVo.getCurrentPage(), resourceVo.getPageSize());
        List<Resource> allResource = resourceMapper.findAllResource(resourceVo);
        PageInfo<Resource> adPageInfo = new PageInfo<Resource>(allResource);
        return adPageInfo;
    }

}