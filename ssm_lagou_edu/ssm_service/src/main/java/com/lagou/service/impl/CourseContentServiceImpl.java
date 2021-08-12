package com.lagou.service.impl;

import com.lagou.domain.Course;
import com.lagou.domain.CourseLesson;
import com.lagou.domain.CourseSection;
import com.lagou.mapper.CourseContentMapper;
import com.lagou.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: CourseContentServiceImpl
 * @Author: CYJ
 * @Date: 2021-08-09 10:24:45 
 * @Description: 
*/
@Service
public class CourseContentServiceImpl implements CourseContentService {
    @Autowired
    private CourseContentMapper contentMapper;
    @Override
    public List<CourseSection> findSectionAndLessonByCourseId(int courseId) {
        List<CourseSection> sectionList =
                contentMapper.findSectionAndLessonByCourseId(courseId);
        return sectionList;
    }

    @Override
    public Course findCourseByCourseId(int courseId) {
        Course course = contentMapper.findCourseByCourseId(courseId);
        return course;
    }

    @Override
    public void saveSection(CourseSection section) {
        //补全信息
        Date date = new Date();
        section.setCreateTime(date);
        section.setUpdateTime(date);
        contentMapper.saveSection(section);
    }

    @Override
    public void updateSection(CourseSection section) {
        //补全信息
        Date date = new Date();
        section.setUpdateTime(date);
        contentMapper.updateSection(section);
    }

    @Override
    public void updateSectionStatus(int id,int status) {
        //封装数据
        CourseSection section = new CourseSection();
        section.setId(id);
        section.setStatus(status);
        section.setUpdateTime(new Date());
        contentMapper.updateSectionStatus(section);
    }
    @Override
    public void saveLesson(CourseLesson lesson) {
        //补全信息
        Date date = new Date();
        lesson.setCreateTime(date);
        lesson.setUpdateTime(date);
        contentMapper.saveLesson(lesson);
    }

    @Override
    public void updateLesson(CourseLesson lesson) {
        Date date = new Date();
        lesson.setUpdateTime(date);
        contentMapper.updateLesson(lesson);
    }

}

