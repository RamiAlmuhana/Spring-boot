package org.duckstudios.todoapp.controllers;

import org.duckstudios.todoapp.dao.TaskDAO;
import org.duckstudios.todoapp.dto.TaskDTO;
import org.duckstudios.todoapp.models.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private TaskDAO taskDAO;

    public TaskController(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> tasks = this.taskDAO.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public ResponseEntity<String> createTask(@RequestBody TaskDTO taskDTO) {
        this.taskDAO.createTask(taskDTO);
        return ResponseEntity.ok("Het is gelukt!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTask(@PathVariable long id, @RequestBody TaskDTO taskDTO) {
        this.taskDAO.updateTaskById(id, taskDTO);
        return ResponseEntity.ok("Updated task with id " + id);
    }

    @PutMapping("/check/{id}")
    public ResponseEntity<String> checkTask(@PathVariable long id) {
        this.taskDAO.updateTaskStatus(id, true);
        return ResponseEntity.ok("Finished task with id " + id);
    }

    @PutMapping("/uncheck/{id}")
    public  ResponseEntity<String> uncheckTask(@PathVariable long id) {
        this.taskDAO.updateTaskStatus(id, false);
        return ResponseEntity.ok("Unchecked task with id " + id);
    }
}
