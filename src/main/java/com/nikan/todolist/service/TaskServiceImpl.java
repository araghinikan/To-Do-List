package com.nikan.todolist.service;

import com.nikan.todolist.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class TaskServiceImpl implements TaskService {

    @Override
    public Task add(Task task) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Task findById(int id) {
        return null;
    }

    @Override
    public Page<Task> findAll(Pageable pageable) {
        return null;
    }
}