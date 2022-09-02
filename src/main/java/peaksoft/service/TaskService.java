package peaksoft.service;

import peaksoft.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTask(Long lessonId);

    void addTask(Long id, Task task);

    Task getTaskById(Long id);

    void updateTask(Long id, Task task);

    void deleteTask(Long id);
}
