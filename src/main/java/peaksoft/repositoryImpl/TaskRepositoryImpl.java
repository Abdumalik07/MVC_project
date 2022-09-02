package peaksoft.repositoryImpl;

import org.springframework.stereotype.Repository;
import peaksoft.entity.Lesson;
import peaksoft.entity.Task;
import peaksoft.repository.TaskRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class TaskRepositoryImpl implements TaskRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Task> getAllTask(Long id) {
        return manager.createQuery("select t from Task t where t.lesson.id = :id",Task.class)
                .setParameter("id",id).getResultList();
    }

    @Override
    public void addTask(Long lessonId, Task task) {
        Lesson lesson = manager.find(Lesson.class, lessonId);
        lesson.addTasks(task);
        task.setLesson(lesson);
    manager.persist(task);
    }

    @Override
    public Task getTaskById(Long id) {
        return manager.find(Task.class,id);
    }

    @Override
    public void updateTask(Long id, Task task) {
        Task task1 = manager.find(Task.class,id);
        task1.setTaskName(task.getTaskName());
        task1.setTaskText(task.getTaskText());
        task1.setLocalDate(task.getLocalDate());
        manager.merge(task1);
    }

    @Override
    public void deleteTask(Long id) {
        Task task = manager.find(Task.class, id);
        task.setLesson(null);
        manager.remove(task);
    }
}
