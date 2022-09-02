package peaksoft.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.entity.Task;
import peaksoft.repository.TaskRepository;
import peaksoft.service.TaskService;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTask(Long id) {
        return taskRepository.getAllTask(id);
    }

    @Override
    public void addTask(Long id, Task task) {
        taskRepository.addTask(id, task);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.getTaskById(id);
    }

    @Override
    public void updateTask(Long id, Task task) {
        taskRepository.updateTask(id, task);

    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteTask(id);
    }

}
