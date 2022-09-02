package peaksoft.repository;

import peaksoft.entity.Company;
import peaksoft.entity.Task;

import java.util.List;

public interface TaskRepository {
    List<Task> getAllTask(Long lessonId);
    void addTask(Long id, Task task);
    Task getTaskById(Long id);
    void updateTask(Long id, Task task);
    void deleteTask(Long id);
}
