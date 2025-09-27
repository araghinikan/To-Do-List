package com.nikan.todolist.service;

import com.nikan.todolist.model.Task;
import com.nikan.todolist.repository.ToDoListRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    private final ToDoListRepository toDoListRepository;

    public TaskServiceImpl(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    @Override
    public Task add(Task task) {
        return toDoListRepository.save(task);
    }

    @Override
    public void delete(int id) {
        toDoListRepository.deleteById(id);
    }

    @Override
    public Task findById(int id) {
        return toDoListRepository.findById(id).orElseThrow(()-> new RuntimeException("Task not found"));
    }

    @Override
    public Page<Task> findAll(Pageable pageable) {
        return toDoListRepository.findAll(pageable);
    }
}