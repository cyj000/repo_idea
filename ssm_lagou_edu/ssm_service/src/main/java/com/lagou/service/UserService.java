package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Role;
import com.lagou.domain.User;
import com.lagou.domain.vo.UserVo;

import java.util.List;

/**
 * @ClassName: UserService
 * @Author: CYJ
 * @Date: 2021-08-11 10:38:41
 * @Description:
 */

public interface UserService {
        /*
    查询所有用户
    */
    public PageInfo findAllUserByPage(UserVo userVo);

    public void updateUserStatus(Integer id,String status);

        /*
    用户登录
    */
    public User login(User user) throws Exception;

    /**
     * 获取用户拥有的角色
     * */
    public List<Role> findUserRelationRoleById(int id) ;

        /*
    用户关联角色
    */
    void userContextRole(UserVo userVo);

    /*
     * 获取用户权限
     * */
    ResponseResult getUserPermissions(Integer id);
}
