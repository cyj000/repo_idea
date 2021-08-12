package com.lagou.service;

import com.lagou.domain.Course;
import com.lagou.domain.CourseLesson;
import com.lagou.domain.CourseSection;

import java.util.List;

/**
 * @ClassName: CourseContentService
 * @Author: CYJ
 * @Date: 2021-08-09 10:24:25
 * @Description:
 */

public interface CourseContentService {
    /**
     * 查询指定课程下的章节、课时信息
     * @param courseId
     * @return
     */
    public List<CourseSection> findSectionAndLessonByCourseId(int courseId);

    /**
     * 回显课程信息
     * @param courseId
     * @return
     */
    public Course findCourseByCourseId(int courseId);

    /**
     * 新增章节信息
     * @param section
     */
    public void saveSection(CourseSection section);

    /**
     * 更新章节信息
     * @param section
     */
    public void updateSection(CourseSection section);

    public void updateSectionStatus(int id,int status);

    public void saveLesson(CourseLesson lesson);


    void updateLesson(CourseLesson lesson);
}
