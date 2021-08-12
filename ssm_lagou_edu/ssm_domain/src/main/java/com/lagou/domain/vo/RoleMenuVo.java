package com.lagou.domain.vo;

import java.util.List;

/**
 * @ClassName: RoleMenuVo
 * @Author: CYJ
 * @Date: 2021-08-11 12:07:16
 * @Description:
 */
public class RoleMenuVo {
    private int roleId;
    private List<Integer> menuIdList;

    @Override
    public String toString() {
        return "RoleMenuVo{" +
                "roleId=" + roleId +
                ", menuIdList=" + menuIdList +
                '}';
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public List<Integer> getMenuIdList() {
        return menuIdList;
    }

    public void setMenuIdList(List<Integer> menuIdList) {
        this.menuIdList = menuIdList;
    }
}
