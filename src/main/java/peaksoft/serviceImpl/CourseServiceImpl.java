package peaksoft.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.entity.Course;
import peaksoft.repository.CourseRepository;
import peaksoft.service.CourseService;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourse(Long companyId) {
        return courseRepository.getAllCourse(companyId);
    }

    @Override
    public void addCourse(Long id, Course course) {
        courseRepository.addCourse(id, course);
    }

    @Override
    public Course getCourseById(long id) {
        return courseRepository.getCourseById(id);
    }

    @Override
    public void updateCourse(Long courseId, Course course) {
        courseRepository.updateCourse(courseId, course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteCourse(id);
    }
}
