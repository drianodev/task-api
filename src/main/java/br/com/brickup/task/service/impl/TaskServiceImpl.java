package br.com.brickup.task.service.impl;

import br.com.brickup.task.exception.CustomServiceException;
import br.com.brickup.task.exception.EntityNotFoundException;
import br.com.brickup.task.model.dto.TaskDTO;
import br.com.brickup.task.model.entity.Task;
import br.com.brickup.task.repository.TaskRepository;
import br.com.brickup.task.service.TaskService;
import br.com.brickup.task.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<TaskDTO> getAllTasks() {
        try {
            List<Task> tasks = taskRepository.findAll();
            return MapperUtils.convertList(tasks, TaskDTO.class);
        } catch (DataAccessException ex) {
            throw new CustomServiceException("Falha ao recuperar tarefas", ex);
        }
    }

    @Override
    public TaskDTO getTaskById(Long id) {
        try {
            Optional<Task> taskOptional = taskRepository.findById(id);
            return taskOptional.map(task -> MapperUtils.convert(task, TaskDTO.class)).orElseThrow(() ->
                    new EntityNotFoundException("Tarefa com ID " + id + " não encontrada"));
        } catch (DataAccessException ex) {
            throw new CustomServiceException("Falha ao recuperar tarefa com ID: " + id, ex);
        }
    }

    @Override
    public TaskDTO createTask(TaskDTO taskDTO) {
        try {
            Task task = MapperUtils.convert(taskDTO, Task.class);
            Task savedTask = taskRepository.save(task);
            return MapperUtils.convert(savedTask, TaskDTO.class);
        } catch (DataAccessException ex) {
            throw new CustomServiceException("Falha ao criar tarefa", ex);
        }
    }

    @Override
    public TaskDTO updateTask(Long id, TaskDTO taskDTO) {
        try {
            Task existingTask = taskRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Tarefa com ID " + id + " não encontrada"));

            MapperUtils.merge(taskDTO, existingTask);
            Task updatedTask = taskRepository.save(existingTask);
            return MapperUtils.convert(updatedTask, TaskDTO.class);
        } catch (DataAccessException ex) {
            throw new CustomServiceException("Falha ao recuperar tarefa com ID: " + id, ex);
        }
    }

    @Override
    public void deleteTask(Long id) {
        try {
            taskRepository.deleteById(id);
        } catch (DataAccessException ex) {
            throw new CustomServiceException("Falha ao recuperar tarefa com ID: " + id, ex);
        }
    }
}
