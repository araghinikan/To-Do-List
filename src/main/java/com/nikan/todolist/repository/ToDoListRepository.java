package com.nikan.todolist.repository;

import com.nikan.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepository extends JpaRepository<Task, Integer>{
}