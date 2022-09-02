package peaksoft.repositoryImpl;

import org.springframework.stereotype.Repository;
import peaksoft.entity.Company;
import peaksoft.entity.Course;
import peaksoft.entity.Instructor;
import peaksoft.repository.InstructorRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class InstructorRepositoryImpl implements InstructorRepository {

    @PersistenceContext
    private EntityManager manager;
    public List<Instructor> getAllInstructor(Long id) {

        return  manager.createQuery("select i from Instructor i where i.company.id = :id",Instructor.class).
                setParameter("id",id).getResultList();
    }

    @Override
    public void addInstructor(Long id, Instructor instructor) {
        Company company = manager.find(Company.class,id);
        company.addInstructor(instructor);
        instructor.setCompany(company);
        manager.persist(instructor);
    }

    @Override
    public Instructor getInstructorById(long id) {
        return manager.find(Instructor.class,id);
    }

    @Override
    public void updateInstructor(Long id, Instructor instructor) {
        Instructor instructor1 = manager.find(Instructor.class,id);
        instructor1.setFirstName(instructor.getFirstName());
        instructor1.setLastName(instructor.getLastName());
        instructor1.setEmail(instructor.getEmail());
        instructor1.setPhoneNumber(instructor.getPhoneNumber());
        instructor1.setSpecialization(instructor.getSpecialization());
        manager.persist(instructor1);
    }

    @Override
    public void deleteInstructor(Long id) {
        Instructor instructor = manager.find(Instructor.class,id);
        for(Course course : instructor.getCourses()){
            course.getInstructors();
        }
        manager.remove(instructor);
    }

    @Override
    public void assignInstructorToCourse(Long instructorId, Long courseId) {
    Instructor instructor = manager.find(Instructor.class,instructorId);
    Course course =manager.find(Course.class, courseId);
    instructor.addCourse(course);
    course.addInstructors(instructor);
    manager.merge(instructor);

    }
}
