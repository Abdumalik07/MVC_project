package peaksoft.repository;

import peaksoft.entity.Company;
import peaksoft.entity.Lesson;

import java.util.List;

public interface LessonRepository {
    List<Lesson> getAllLesson(Long id);
    void addLesson(Long courseId, Lesson lesson);
    Lesson getLessonById(Long id);
    void updateLesson(Long id, Lesson lesson);
    void deleteLesson(Long id);
}
