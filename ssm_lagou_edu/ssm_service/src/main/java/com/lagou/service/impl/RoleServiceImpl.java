package com.lagou.service.impl;

import com.lagou.domain.Role;
import com.lagou.domain.Role_menu_relation;
import com.lagou.domain.vo.RoleMenuVo;
import com.lagou.mapper.RoleMapper;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: RoleServiceImpl
 * @Author: CYJ
 * @Date: 2021-08-11 11:45:29
 * @Description:
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> findAllRole(Role role) {
        List<Role> allRole = roleMapper.findAllRole(role);
        return allRole;
    }
    @Override
    public List<String> findMenuByRoleId(Integer roleId) {
        List<String> list = roleMapper.findMenuByRoleId(roleId);
        return list;
    }

    @Override
    public void RoleContextMenu(RoleMenuVo roleMenuVo) {
        // 清空中间表
        roleMapper.deleteRoleContextMenu(roleMenuVo.getRoleId());
        Date date = new Date();
        for (Integer mid : roleMenuVo.getMenuIdList()) {
            Role_menu_relation role_menu_relation = new Role_menu_relation();
            role_menu_relation.setRoleId(roleMenuVo.getRoleId());
            role_menu_relation.setMenuId(mid);
            role_menu_relation.setCreatedTime(date);
            role_menu_relation.setUpdatedTime(date);
            role_menu_relation.setCreatedBy("system");
            role_menu_relation.setUpdatedby("system");
            roleMapper.RoleContextMenu(role_menu_relation);
        }
    }

    @Override
    public void deleteRole(Integer id) {
        // 清空中间表
        roleMapper.deleteRoleContextMenu(id);
        roleMapper.deleteRole(id);
    }
}
