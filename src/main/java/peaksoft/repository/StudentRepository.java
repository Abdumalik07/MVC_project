package peaksoft.repository;

import peaksoft.entity.Company;
import peaksoft.entity.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> getAllStudent(Long id);
    void addStudent(Long id,Student student);
    Student getStudentById(Long id);
    void updateStudent(Long id, Student student);
    void deleteStudent(Long id);

    void assignStudentToCourse(Long studentId,Long courseId);
}
