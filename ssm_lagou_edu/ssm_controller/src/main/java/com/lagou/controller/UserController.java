package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Role;
import com.lagou.domain.User;
import com.lagou.domain.vo.UserVo;
import com.lagou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName: UserController
 * @Author: CYJ
 * @Date: 2021-08-11 10:40:17
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAllUserByPage")
    public ResponseResult findAllUserByPage(@RequestBody UserVo userVo) {
        PageInfo pageInfo = userService.findAllUserByPage(userVo);
        List<User> list = pageInfo.getList();
        System.out.println(list);
        return ResponseResult.success(pageInfo);
    }

    @RequestMapping("/updateUserStatus")
        public ResponseResult updateUserStatus(@RequestParam Integer id, @RequestParam String status){
        try{
            if (status.equals("ENABLE")){
                userService.updateUserStatus(id,status);
            }else{
                userService.updateUserStatus(id,"DISABLE");
            }
            Map<String,String> map=new HashMap<>();
            map.put("status",status);
            return ResponseResult.success(map);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }

    /**
     * 用户登录
     * */
    @RequestMapping("/login")
    public ResponseResult login(User user, HttpServletRequest request) throws
            Exception {
        User login = userService.login(user);
        ResponseResult result = null;
        if(login !=null ){
            //保存access_token
            Map<String,Object> map = new HashMap<>();
            String access_token = UUID.randomUUID().toString();
            map.put("access_token", access_token);
            map.put("user_id",login.getId());
            map.put("user",login);
            HttpSession session = request.getSession();
            session.setAttribute("user_id",login.getId());
            session.setAttribute("access_token",access_token);
            session.setAttribute("access_token",access_token);

            result = new ResponseResult(true,1,"响应成功",map);
        }else{
            result =new ResponseResult(true,1,"用户名密码错误",null);
        }
        return result;
    }

    /*
    获取用户拥有的角色
    */
    @RequestMapping("/findUserRoleById")
    public ResponseResult findUserRoleById(int id){
        List<Role> roleList = userService.findUserRelationRoleById(id);
        return new ResponseResult(true,200,"分配角色回显成功",roleList);
    }

        /*
    分配角色
    */
    @RequestMapping("/userContextRole")
    public ResponseResult userContextRole(@RequestBody UserVo userVo){
        userService.userContextRole(userVo);
        return new ResponseResult(true,200,"分配角色成功",null);
    }

    /**
     * 获取用户权限
     * */
    @RequestMapping("/getUserPermissions")
    public ResponseResult getUserPermissions(HttpServletRequest request){
        //获取请求头中的 token
        String token = request.getHeader("Authorization");
        //获取session中的access_token
        HttpSession session = request.getSession();
        String access_token = (String)session.getAttribute("access_token");
        //判断
        if(token.equals(access_token)){
            int user_id = (Integer)session.getAttribute("user_id");
            ResponseResult result = userService.getUserPermissions(user_id);
            return result;
        }else{
            ResponseResult result = new ResponseResult(false,400,"获取失败","");
            return result;
        }
    }
}


