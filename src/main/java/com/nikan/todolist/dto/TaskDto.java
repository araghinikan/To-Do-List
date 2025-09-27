package com.nikan.todolist.dto;

import com.nikan.todolist.model.Task;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TaskDto {
    private String title;
    private String description;

    public Task convertToTask() {
        Task task = new Task();
        task.setTitle(this.title);
        task.setDescription(this.description);
        return task;
    }

    @NotBlank(message = "event.dto.title.blank")
    @Size(min = 3, max = 100, message = "event.dto.title.size")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NotBlank(message = "description.event.blank")
    @Size(min = 20, max = 500, message = "description.event.size")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}