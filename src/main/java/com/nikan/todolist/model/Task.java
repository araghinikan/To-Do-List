package com.nikan.todolist.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
public class Task {
    private int id;
    private String title;
    private String description;
    private Status status;
    private LocalDate MadeDate;

    public Task changeStatus() {
        if (this.status == Status.COMPLETED) {
            this.status = Status.PENDING;
        }else if (this.status == Status.PENDING) {
            this.status = Status.COMPLETED;
        }
        return this;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(nullable = false, unique = true)
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

    @Enumerated(EnumType.STRING)
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @CreationTimestamp
    public LocalDate getMadeDate() {
        return MadeDate;
    }

    public void setMadeDate(LocalDate madeDate) {
        MadeDate = madeDate;
    }
}