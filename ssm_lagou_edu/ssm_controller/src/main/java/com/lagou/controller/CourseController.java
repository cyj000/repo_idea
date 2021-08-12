package com.lagou.controller;

import com.lagou.domain.Constant;
import com.lagou.domain.Course;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.vo.CourseVO;
import com.lagou.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: CourseController
 * @Author: CYJ
 * @Date: 2021-08-07 14:55:54
 * @Description:
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    /**
     * 查询课程信息&条件查询 接口
     */
    @RequestMapping("/findCourseByCondition")
    public ResponseResult findCourseByCondition(@RequestBody CourseVO courseVO) {
        List<Course> courseList = courseService.findCourseByCondition(courseVO);

        return ResponseResult.success("响应成功", courseList);
    }

    /**
     * 图片上传接口
     */
    @RequestMapping("/courseUpload")
    public ResponseResult fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        try {
            //1.判断文件是否为空
            if (file.isEmpty()) {
                throw new RuntimeException();
            }
            //2.获取项目部署路径
            // D:\apache-tomcat-8.5.56\webapps\ssm_web\
            //V:\\web\\apache-tomcat-8.5.55\\webapps\ssm
            String realPath = request.getServletContext().getRealPath("/");
            // D:\apache-tomcat-8.5.56\webapps\
            String webappsPath = realPath.substring(0, realPath.indexOf("ssm"));
            //3.获取原文件名
            String fileName = file.getOriginalFilename();
            //4.新文件名
            String newFileName = System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));
            //5.上传文件
            String uploadPath = webappsPath + "upload\\";
            File filePath = new File(uploadPath, newFileName);
            //如果目录不存在就创建目录
            if (!filePath.getParentFile().exists()) {
                filePath.getParentFile().mkdirs();
                System.out.println("创建目录: " + filePath);
            }
            file.transferTo(filePath);
            //6.将文件名和文件路径返回
            Map<String, String> map = new HashMap<>();
            map.put("fileName", newFileName);
//            map.put("filePath", webappsPath + "/upload/" + newFileName);
            map.put("filePath", Constant.LOCAL_URL + newFileName);
            ResponseResult result = new ResponseResult(true, 200, "响应成功", map);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 保存&修改课程信息接口
     */
    @RequestMapping("/saveOrUpdateCourse")
    public ResponseResult saveOrUpdateCourse(@RequestBody CourseVO courseVO) {
        try {
            if (courseVO.getId() == null) {
                courseService.saveCourseOrTeacher(courseVO);
            } else {
                courseService.updateCourseOrTeacher(courseVO);
            }
            return ResponseResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据课程id查询课程信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/findCourseById")
    public ResponseResult findCourseById(@RequestParam int id) {
        try {
            CourseVO courseVO = courseService.findCourseById(id);
            return ResponseResult.success("响应成功", courseVO);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 修改课程状态
     * */
    @RequestMapping("/updateCourseStatus")
    public ResponseResult updateCourseStatus(@RequestParam int id,@RequestParam int status){
        try {
            //执行修改操作
            courseService.updateCourseStatus(id, status);
            //保存修改后的状态,并返回
            Map<String,Integer> map = new HashMap<>();
            map.put("status",status);
            return ResponseResult.success(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
