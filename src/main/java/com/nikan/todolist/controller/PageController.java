package com.nikan.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {
    @GetMapping
    public String index(){
        return "index";
    }

    @GetMapping("/add")
    public String addTask(){
        return "add-task";
    }

    @GetMapping("/tasks")
    public String tasks(){
        return "tasks";
    }
}