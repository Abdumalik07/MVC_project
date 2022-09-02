package peaksoft.repositoryImpl;

import org.springframework.stereotype.Repository;
import peaksoft.entity.Company;
import peaksoft.entity.Course;
import peaksoft.repository.CourseRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class CourseRepositoryImpl implements CourseRepository {
    @PersistenceContext
    private EntityManager manager;
    @Override
    public List<Course> getAllCourse(Long id) {

        return manager.createQuery("SELECT c FROM Course c where c.company.id = : id",Course.class)
                .setParameter("id",id).getResultList();
    }
    @Override
    public void addCourse(Long id, Course course) {
        Company company = manager.find(Company.class,id);
        company.addCourse(course);
        course.setCompany(company);
        manager.persist(course);
    }
    @Override
    public Course getCourseById(Long id) {
        return manager.find(Course.class,id);
    }
    @Override
    public void updateCourse(Long id, Course course) {
        Course course1 = manager.find(Course.class,id);
        course1.setCourseName(course.getCourseName());
        course1.setLocalDate(course.getLocalDate());
        course1.setDuration(course.getDuration());
        course1.setImage(course.getImage());
        course1.setDescription(course.getDescription());
        manager.merge(course1);

    }
    @Override
    public void deleteCourse(Long id) {
    manager.remove(manager.find(Course.class, id));
    }
}
