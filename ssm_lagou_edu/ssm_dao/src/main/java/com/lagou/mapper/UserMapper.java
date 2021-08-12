package com.lagou.mapper;

import com.lagou.domain.Menu;
import com.lagou.domain.Resource;
import com.lagou.domain.Role;
import com.lagou.domain.User;
import com.lagou.domain.User_Role_relation;
import com.lagou.domain.vo.UserVo;

import java.util.List;

/**
 * @ClassName: UserMapper
 * @Author: CYJ
 * @Date: 2021-08-11 10:36:46
 * @Description:
 */

public interface UserMapper {
    /**
    查询所有用户
    */
    public List<User> findAllUserByPage(UserVo userVo);

    public void updateUserStatus(User user);

   /**
    用户登陆
    */
    public User login(User user);

    /**
     * 根据ID查询用户当前角色
     * */
    public List<Role> findUserRelationRoleById(int id);

   /**
    根据用户ID清空中间表
    */
    void deleteUserContextRole(Integer userId);
    /**
    分配角色
    */
    void userContextRole(User_Role_relation user_role_relation);

    /**
     * 根据角色id,查询角色拥有的顶级菜单信息
     * */
    public List<Menu> findParentMenuByRoleId(List<Integer> ids);
    /**
     * 根据PID 查询子菜单信息
     * */
    public List<Menu> findSubMenuByPid(int pid);
    /**
     * 获取用户拥有的资源权限信息
     * */
    public List<Resource> findResourceByRoleId(List<Integer> ids);

}
