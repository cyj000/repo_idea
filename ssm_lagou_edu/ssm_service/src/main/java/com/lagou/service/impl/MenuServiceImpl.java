package com.lagou.service.impl;

import com.lagou.domain.Menu;
import com.lagou.mapper.MenuMapper;
import com.lagou.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: MenuServiceImpl
 * @Author: CYJ
 * @Date: 2021-08-11 11:50:51
 * @Description:
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List<Menu> findSubMenuListByPid(int pid) {
        List<Menu> menuList = menuMapper.findSubMenuListByPid(pid);
        return menuList;
    }
    @Override
    public List<Menu> findAllMenu() {
        List<Menu> list = menuMapper.findAllMenu();
        return list;
    }

    @Override
    public Menu findMenuById(int id) {
        Menu menu=menuMapper.findMenuById(id);
        return menu;
    }

}
