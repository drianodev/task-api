package br.com.brickup.task.service.impl;

import br.com.brickup.task.model.dto.TaskDTO;
import br.com.brickup.task.model.entity.Task;
import br.com.brickup.task.repository.TaskRepository;
import br.com.brickup.task.service.TaskService;
import br.com.brickup.task.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<TaskDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return MapperUtils.convertList(tasks, TaskDTO.class);
    }

    @Override
    public TaskDTO getTaskById(Long id) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        return taskOptional.map(task -> MapperUtils.convert(task, TaskDTO.class)).orElse(null);
    }

    @Override
    public TaskDTO createTask(TaskDTO taskDTO) {
        Task task = MapperUtils.convert(taskDTO, Task.class);
        Task savedTask = taskRepository.save(task);
        return MapperUtils.convert(savedTask, TaskDTO.class);
    }

    @Override
    public TaskDTO updateTask(Long id, TaskDTO taskDTO) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isPresent()) {
            Task existingTask = taskOptional.get();
            MapperUtils.merge(taskDTO, existingTask);
            Task updatedTask = taskRepository.save(existingTask);
            return MapperUtils.convert(updatedTask, TaskDTO.class);
        }
        return null;
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
