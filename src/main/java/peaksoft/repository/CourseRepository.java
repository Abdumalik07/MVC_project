package peaksoft.repository;

import peaksoft.entity.Course;

import java.util.List;

public interface CourseRepository {
    List<Course> getAllCourse(Long id);
    void addCourse(Long id, Course course);
    Course getCourseById(Long id);
    void updateCourse(Long id, Course course);
    void deleteCourse(Long id);
}
