package org.example.repository;

import org.example.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    Optional findById (Long id);
    Task save (Task task);
    List<Task> findAll();
    void deleteById(Long id);

}
