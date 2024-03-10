package org.duckstudios.todoapp.controllers;

import org.duckstudios.todoapp.models.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @GetMapping
    public Task getAllTasks(){
        Task myTask = new Task("Videos maken", "Springboot videos maken");
        return myTask;
    }


}
