package com.lagou.mapper;

import com.lagou.domain.Course;
import com.lagou.domain.CourseLesson;
import com.lagou.domain.Teacher;
import com.lagou.domain.vo.CourseVO;

import java.util.List;

/**
 * @ClassName: CourseDao
 * @Author: CYJ
 * @Date: 2021-08-07 14:48:53
 * @Description:
 */

public interface CourseMapper {
    /**
     * 多条件课程列表查询
     */
    public List<Course> findCourseByCondition(CourseVO courseVo);

    /**
     * 保存课程信息
     * */
    public int saveCourse(Course course);
    /**
     *保存讲师信息
     */
    public void saveTeacher(Teacher teacher);

    /**
     * 根据id 获取课程信息
     * */
    public CourseVO findCourseById(int id);

    /**
     * 修改课程信息
     * */
    public void updateCourse(Course course);
    /**
     * 修改讲师信息
     * */
    public void updateTeacher(Teacher teacher);

    /**
     * 修改课程状态
     * */
    public void updateCourseStatus(Course course);

    /**
     * 保存课时
     * */
    public void saveLesson(CourseLesson lesson);


}

