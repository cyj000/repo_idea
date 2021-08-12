package com.lagou.mapper;

import com.lagou.domain.Menu;

import java.util.List;

/**
 * @ClassName: MenuMapper
 * @Author: CYJ
 * @Date: 2021-08-11 11:46:51
 * @Description:
 */

public interface MenuMapper {
    /**
     * 查询全部的父子菜单信息
     * */
    public List<Menu> findSubMenuListByPid(int pid);


    /**
     * 查询菜单列表
     * */
    public List<Menu> findAllMenu();

    /**
     * 根据id查询菜单
     * @param id
     * @return
     */
    Menu findMenuById(int id);
}
