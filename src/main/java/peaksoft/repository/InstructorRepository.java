package peaksoft.repository;

import peaksoft.entity.Company;
import peaksoft.entity.Instructor;

import java.util.List;

public interface InstructorRepository {
    List<Instructor> getAllInstructor(Long id);
    void addInstructor(Long id, Instructor instructor);
    Instructor getInstructorById(long id);
    void updateInstructor(Long id, Instructor instructor);
    void deleteInstructor(Long id);
    void assignInstructorToCourse(Long instructorId, Long courseId);
}
