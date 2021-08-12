package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.domain.Menu;
import com.lagou.domain.Resource;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Role;
import com.lagou.domain.User;
import com.lagou.domain.User_Role_relation;
import com.lagou.domain.vo.UserVo;
import com.lagou.mapper.UserMapper;
import com.lagou.service.UserService;
import com.lagou.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: UserServiceImpl
 * @Author: CYJ
 * @Date: 2021-08-11 10:38:54
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public PageInfo findAllUserByPage(UserVo userVo) {
        // 使用pageHelper
        PageHelper.startPage(userVo.getCurrentPage(), userVo.getPageSize());

        List<User> allUser = userMapper.findAllUserByPage(userVo);

        PageInfo<User> pageInfo = new PageInfo<User>(allUser);

        System.out.println("总条数：" + pageInfo.getTotal());
        System.out.println("总页数：" + pageInfo.getPages());
        System.out.println("当前页：" + pageInfo.getPageNum());
        System.out.println("每页显示长度：" + pageInfo.getPageSize());
        System.out.println("是否第一页：" + pageInfo.isIsFirstPage());
        System.out.println("是否最后一页：" + pageInfo.isIsLastPage());
        return pageInfo;
    }

    @Override
    public void updateUserStatus(Integer id, String status) {
        User user = new User();
        user.setUpdate_time(new Date());
        user.setId(id);
        user.setStatus(status);
        userMapper.updateUserStatus(user);
    }

    /**
     * 用户登录
     */
    @Override
    public User login(User user) throws Exception {
        User user2 = userMapper.login(user);
        if (user2 != null && Md5.verify(user.getPassword(), "lagou", user2.getPassword())) {
            return user2;
        } else {
            return null;
        }
    }

    /**
     * 获取用户拥有的角色
     * */
    @Override
    public List<Role> findUserRelationRoleById(int id) {
        List<Role> roleList = userMapper.findUserRelationRoleById(id);
        return roleList;
    }

    /*
用户关联角色
*/
    @Override
    public void userContextRole(UserVo userVo) {
        // 根据用户ID清空中间表的关联关系
        userMapper.deleteUserContextRole(userVo.getUserId());
        // 向中间表添加记录
        for (Integer roleId : userVo.getRoleIdList()) {
            User_Role_relation user_role_relation = new User_Role_relation();
            user_role_relation.setUserId(userVo.getUserId());
            user_role_relation.setRoleId(roleId);
            Date date = new Date();
            user_role_relation.setCreatedTime(date);
            user_role_relation.setUpdatedTime(date);
            user_role_relation.setCreatedBy("system");
            user_role_relation.setUpdatedby("system");
            userMapper.userContextRole(user_role_relation);
        }
    }

    @Override
    public ResponseResult getUserPermissions(Integer id) {
        //1.获取当前用户拥有的角色
        List<Role> roleList = userMapper.findUserRelationRoleById(id);
        //2.获取角色ID,保存到 list
        List<Integer> list = new ArrayList<>();
        for (Role role : roleList) {
            list.add(role.getId());
        }
        //3.根据角色id查询 父菜单
        List<Menu> parentMenu = userMapper.findParentMenuByRoleId(list);
        //4.封装父菜单下的子菜单

        for (Menu menu : parentMenu) {
            List<Menu> subMenu = userMapper.findSubMenuByPid(menu.getId());
            menu.setSubMenuList(subMenu);
        }
        //5.获取资源权限
        List<Resource> resourceList = userMapper.findResourceByRoleId(list);
        //6.封装数据
        Map<String,Object> map = new HashMap<>();
        map.put("menuList",parentMenu); //menuList: 菜单权限数据
        map.put("resourceList",resourceList);//resourceList: 资源权限数据
        ResponseResult result = new ResponseResult(true,200,"响应成功",map);
        return result;
    }


}
