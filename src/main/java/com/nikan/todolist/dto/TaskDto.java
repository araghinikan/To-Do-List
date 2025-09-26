package com.nikan.todolist.dto;

import com.nikan.todolist.model.Task;

public class TaskDto {
    private String title;
    private String description;

    public Task convertToTask() {
        Task task = new Task();
        task.setTitle(this.title);
        task.setDescription(this.description);
        return task;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}