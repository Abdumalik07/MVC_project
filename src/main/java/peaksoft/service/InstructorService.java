package peaksoft.service;

import peaksoft.entity.Instructor;

import java.util.List;

public interface InstructorService {
    List<Instructor> getAllInstructor(Long id);

    void addInstructor(Long id, Instructor instructor);

    Instructor getInstructorById(Long id);

    void updateInstructor(Long id, Instructor instructor);

    void deleteInstructor(Long id);

    void assignInstructorToCourse(Long instructorId, Long courseId);
}
