package com.lagou.service.impl;

import com.lagou.domain.Course;
import com.lagou.domain.Teacher;
import com.lagou.domain.vo.CourseVO;
import com.lagou.mapper.CourseMapper;
import com.lagou.service.CourseService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: CourseServiceImpl
 * @Author: CYJ
 * @Date: 2021-08-07 14:54:14
 * @Description:
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> findCourseByCondition(CourseVO courseVO) {
        List<Course> courseList = courseMapper.findCourseByCondition(courseVO);
        return courseList;
    }

    @Override
    public void saveCourseOrTeacher(CourseVO courseVO) {
        try{
            //创建时间
            Date date=new Date();
            Course course=new Course();
            BeanUtils.copyProperties(course,courseVO);
            course.setCreateTime(date);
            course.setUpdateTime(date);
            //保存课程信息
            courseMapper.saveCourse(course);

            //获取新插入数据的id
            int id=course.getId();

            Teacher teacher=new Teacher();
            BeanUtils.copyProperties(teacher,courseVO);
            teacher.setCourseId(id);
            teacher.setCreateTime(date);
            teacher.setUpdateTime(date);
            courseMapper.saveTeacher(teacher);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public CourseVO findCourseById(int id) {
        return courseMapper.findCourseById(id);
    }

    @Override
    public void updateCourseOrTeacher(CourseVO courseVO) {
        try {
                //封装课程信息
            Course course = new Course();
            BeanUtils.copyProperties(course,courseVO);
            //补全信息
            Date date = new Date();
            course.setUpdateTime(date);
            //更新课程
            courseMapper.updateCourse(course);
            //封装讲师信息
            Teacher teacher = new Teacher();
            BeanUtils.copyProperties(teacher,courseVO);
            //补全信息
            teacher.setCourseId(course.getId());
            teacher.setUpdateTime(date);
            //更新讲师信息
            courseMapper.updateTeacher(teacher);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCourseStatus(int id,int status) {
        try {
            //封装数据
            Course course = new Course();
            course.setStatus(status);
            course.setId(id);
            course.setUpdateTime(new Date());
            //调用Dao
            courseMapper.updateCourseStatus(course);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

