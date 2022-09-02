package peaksoft.repositoryImpl;

import org.springframework.stereotype.Repository;
import peaksoft.entity.Company;
import peaksoft.entity.Course;
import peaksoft.entity.Student;
import peaksoft.repository.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.PrimitiveIterator;

@Repository
@Transactional
public class StudentRepositoryImpl implements StudentRepository {
    @PersistenceContext
    private EntityManager manager;
    @Override
    public List<Student> getAllStudent(Long id) {
        return manager.createQuery("select s from Student s where s.company.id = :id",Student.class)
                .setParameter("id",id).getResultList();
    }
    @Override
    public void addStudent(Long companyId,Student student) {
        Company company = manager.find(Company.class,companyId);
        company.addStudent(student);
        student.setCompany(company);
        manager.persist(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return manager.find(Student.class,id);
    }

    @Override
    public void updateStudent(Long id, Student student) {
        Student student1 = manager.find(Student.class,id);
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setPhoneNumber(student.getPhoneNumber());
        student1.setEmail(student.getEmail());
        student1.setStudyFormat(student.getStudyFormat());
        manager.merge(student1);
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = manager.find(Student.class, id);
        student.setCourse(null);
        manager.remove(student);
    }
    public void assignStudentToCourse(Long studentId, Long courseId) {
        Student student = manager.find(Student.class, studentId);
        Course course = manager.find(Course.class, courseId);
        student.setCourse(course);
        course.addStudents(student);
        manager.merge(student);
    }
}
