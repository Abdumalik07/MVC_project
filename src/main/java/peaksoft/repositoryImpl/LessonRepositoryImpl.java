package peaksoft.repositoryImpl;

import org.springframework.stereotype.Repository;
import peaksoft.entity.Company;
import peaksoft.entity.Course;
import peaksoft.entity.Instructor;
import peaksoft.entity.Lesson;
import peaksoft.repository.LessonRepository;
import peaksoft.service.LessonService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class LessonRepositoryImpl implements LessonRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Lesson> getAllLesson(Long id) {
        return manager.createQuery("select l from Lesson l where l.course.id = :id",Lesson.class)
                .setParameter("id",id).getResultList();
    }
    @Override
    public void addLesson(Long courseId, Lesson lesson) {
        Course course = manager.find(Course.class,courseId);
        course.addLessons(lesson);
        lesson.setCourse(course);
        manager.persist(lesson);
    }

    @Override
    public Lesson getLessonById(Long id) {
        return manager.find(Lesson.class,id);
    }

    @Override
    public void updateLesson(Long id, Lesson lesson) {
        Lesson lesson1 = manager.find(Lesson.class,id);
        lesson1.setLessonName(lesson.getLessonName());
        lesson1.setVideo(lesson.getVideo());
        manager.merge(lesson1);
    }

    @Override
    public void deleteLesson(Long id) {
        Lesson lesson = manager.find(Lesson.class, id);
        lesson.setCourse(null);
        manager.remove(lesson);
    }
}
