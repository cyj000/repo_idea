package com.lagou.service;

import com.lagou.domain.Role;
import com.lagou.domain.vo.RoleMenuVo;

import java.util.List;

/**
 * @ClassName: RoleService
 * @Author: CYJ
 * @Date: 2021-08-11 11:45:07
 * @Description:
 */

public interface RoleService {

    public List<Role> findAllRole(Role role);
    /**
     * 根据ID查询角色关联菜单
     * */
    List<String> findMenuByRoleId(Integer roleId);

    void RoleContextMenu(RoleMenuVo roleMenuVo);

    void deleteRole(Integer id);
}

