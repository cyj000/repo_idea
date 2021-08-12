package com.lagou.mapper;

import com.lagou.domain.Course;
import com.lagou.domain.CourseLesson;
import com.lagou.domain.CourseSection;

import java.util.List;

/**
 * @ClassName: CourseContentMapper
 * @Author: CYJ
 * @Date: 2021-08-09 10:19:29
 * @Description:
*/

public interface CourseContentMapper {
    /**
     * 查询课程下的章节与课时信息
     * */
    public List<CourseSection> findSectionAndLessonByCourseId(int courseId);
    /**
     * 回显章节对应的课程信息
     * */
    public Course findCourseByCourseId(int courseId);
    /**
     * 保存章节
     * */
    public void saveSection(CourseSection section);
    /**
     * 修改章节
     * */
    public void updateSection(CourseSection section);

    /**
     * 修改章节状态
     * */
    public void updateSectionStatus(CourseSection section);

    /**
     * 保存课时
     * */
    public void saveLesson(CourseLesson lesson);

    void updateLesson(CourseLesson lesson);
}
