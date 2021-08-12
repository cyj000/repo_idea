package com.lagou.service;

import com.lagou.domain.Menu;

import java.util.List;

/**
 * @ClassName: MenuService
 * @Author: CYJ
 * @Date: 2021-08-11 11:50:30
 * @Description:
 */

public interface MenuService {

    public List<Menu> findSubMenuListByPid(int pid);

    public List<Menu> findAllMenu();

    public Menu findMenuById(int id);

}

