package com.lagou.controller;

import com.lagou.domain.Menu;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Role;
import com.lagou.domain.vo.RoleMenuVo;
import com.lagou.service.MenuService;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: RoleController
 * @Author: CYJ
 * @Date: 2021-08-11 11:46:17
 * @Description:
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    MenuService menuService;

    @RequestMapping("/findAllRole")
    public ResponseResult findAllUserByPage(@RequestBody Role role){
        List<Role> allRole = roleService.findAllRole(role);
        return ResponseResult.success(allRole);
    }

    /**
     * 查询角色关联菜单列表ID
     * */
    @RequestMapping("/findMenuByRoleId")
    public ResponseResult findMenuByRoleId(Integer roleId){
        List<String> menuList = roleService.findMenuByRoleId(roleId);

        return ResponseResult.success(menuList);
    }

        /*
    用户关联菜单 {roleId: 4, menuIdList: [19, 20, 7, 8, 9, 15, 16, 17, 18]}
    */
    @RequestMapping("/RoleContextMenu")
    public ResponseResult RoleContextMenu(@RequestBody RoleMenuVo roleMenuVo){
        roleService.RoleContextMenu(roleMenuVo);
        return ResponseResult.success();
    }

    /**
     * 删除角色
     * */
    @RequestMapping("/deleteRole")
    public ResponseResult deleteRole(Integer id){
        roleService.deleteRole(id);
        return ResponseResult.success();
    }

    /**
     * 回显菜单信息(包括父子菜单的全部信息)
     * */
    @RequestMapping("/findMenuInfoById")
    public ResponseResult findMenuInfoById(@RequestParam int id){
        if(id == -1){
            //添加操作 回显不需要查询 menu信息
            List<Menu> menuList = menuService.findSubMenuListByPid(-1);
            //封装数据
            Map<String,Object> map = new HashMap<>();
            map.put("menuInfo",null);
            map.put("parentMenuList",menuList);
            return ResponseResult.success(map);
        }else{
            //修改操作 回显
            Menu menu = menuService.findMenuById(id);
            List<Menu> menuList = menuService.findSubMenuListByPid(-1);
            Map<String,Object> map = new HashMap<>();
            map.put("menuInfo",menu);
            map.put("parentMenuList",menuList);
            return ResponseResult.success(map);
        }
    }


}

