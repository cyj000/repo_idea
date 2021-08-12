package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourceCategory;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.vo.ResourceVo;
import com.lagou.service.ResourceCategoryService;
import com.lagou.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: ResourceController
 * @Author: CYJ
 * @Date: 2021-08-11 15:10:23
 * @Description:
 */

@RestController
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private ResourceCategoryService resourceCategoryService;
    /**
     * 分页与条件查询
     * */
    @RequestMapping("/findAllResource")
    public ResponseResult findAllResource(@RequestBody ResourceVo resourceVo){
        PageInfo<Resource> allResource =
                resourceService.findAllResource(resourceVo);

        return ResponseResult.success(allResource);
    }

    /**
     * 查询所有分类信息
     */
    /**
     * 分页与条件查询
     * */
    @RequestMapping("/findAllResourceCategory")
    public ResponseResult findAllResourceCategory(){
        List<ResourceCategory> allCategory = resourceCategoryService.findAllCategory();

        return ResponseResult.success(allCategory);
    }
}

