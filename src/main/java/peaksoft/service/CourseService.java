package peaksoft.service;

import peaksoft.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourse(Long companyId);
    void addCourse(Long id, Course course);
    Course getCourseById(long id);
    void updateCourse(Long courseId, Course course);
    void deleteCourse(Long id);
}
