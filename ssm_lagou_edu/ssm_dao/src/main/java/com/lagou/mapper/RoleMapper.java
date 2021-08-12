package com.lagou.mapper;

import com.lagou.domain.Role;
import com.lagou.domain.Role_menu_relation;

import java.util.List;

/**
 * @ClassName: RoleMapper
 * @Author: CYJ
 * @Date: 2021-08-11 11:42:55
 * @Description:
 */

public interface RoleMapper {
    /**
    查询角色列表(条件)
    */
    public List<Role> findAllRole(Role role);

    /**
    根据角色ID查询菜单信息
    */
    List<String> findMenuByRoleId(Integer roleId);

    /**
    角色菜单关联
    */
    void RoleContextMenu(Role_menu_relation role_menu_relation);

    /**
     * 清空角色的关联表
     * @param id
     */
    void deleteRoleContextMenu(int id);

     /**
    删除角色
    */
    void deleteRole(Integer id);


}