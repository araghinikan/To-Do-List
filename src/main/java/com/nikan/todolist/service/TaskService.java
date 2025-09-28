package com.nikan.todolist.service;

import com.nikan.todolist.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskService {
    Task add (Task task);
    void delete(int id);
    Task update (Task task);
    Task findById(int id);
    Page<Task> findAll(Pageable pageable);
}