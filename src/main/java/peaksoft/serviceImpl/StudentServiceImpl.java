package peaksoft.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import peaksoft.entity.Student;
import peaksoft.repository.StudentRepository;
import peaksoft.service.StudentService;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentServiceImpl(StudentRepository  studentRepository) {
        this.studentRepository = studentRepository;
    }



    @Override
    public List<Student> getAllStudent(Long id) {
        return studentRepository.getAllStudent(id);
    }

    @Override
    public void addStudent(Long id, Student student) {
    studentRepository.addStudent(id, student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.getStudentById(id);
    }

    @Override
    public void updateStudent(Long id, Student student) {
    studentRepository.updateStudent(id, student);
    }

    @Override
    public void deleteStudent(Long id) {
    studentRepository.deleteStudent(id);
    }

    @Override
    public void assignStudentToCourse(Long studentId, Long courseId) {
        studentRepository.assignStudentToCourse(studentId,courseId);
    }
}
