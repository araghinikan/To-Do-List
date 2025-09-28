package com.nikan.todolist.controller;

import com.nikan.todolist.dto.TaskDto;
import com.nikan.todolist.model.Task;
import com.nikan.todolist.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/add")
    public ResponseEntity<Object> save(@RequestBody @Valid TaskDto taskDto) {
        try {
            Task saveTask = taskService.add(taskDto.convertToTask());
            return ResponseEntity.ok().body(saveTask.getId());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(null);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable int id) {
        try {
            Task existingTask = taskService.findById(id);
            Task updatedTask = existingTask.changeStatus();
            taskService.update(updatedTask);

            return ResponseEntity.ok(updatedTask);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(null);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<Page<Task>> getAll(Pageable pageable) {
        try {
            return ResponseEntity.ok().body(taskService.findAll(pageable));
        } catch (RuntimeException e) {
            return ResponseEntity.status(409).body(null);
        }
    }

    @GetMapping("/getEventById/{id}")
    public ResponseEntity<Task> getEventById(@PathVariable int id) {
        try {
            return ResponseEntity.ok().body(taskService.findById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(409).body(null);
        }
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Task> delete(@PathVariable int id) {
        try {
            taskService.delete(id);
            return ResponseEntity.ok().body(null);
        } catch (RuntimeException e) {
            return ResponseEntity.status(409).body(null);
        }
    }
}
