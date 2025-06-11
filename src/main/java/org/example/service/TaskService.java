package org.example.service;

import org.example.model.Task;
import org.example.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Optional getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }



}
