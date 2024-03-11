package org.duckstudios.todoapp.dao;


import org.duckstudios.todoapp.dto.TaskDTO;
import org.duckstudios.todoapp.models.Task;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Component
public class TaskDAO {

    private TaskRepository taskRepository;

    public TaskDAO(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks(){
        List<Task> tasks = this.taskRepository.findAll();
        return tasks;
    }

    public void createTask(TaskDTO taskDTO){
        Task task = new Task(taskDTO.name, taskDTO.description);
        this.taskRepository.save(task);
    }


    public void updateTaskById(long id, TaskDTO taskDTO) {
        Optional<Task> optionalTask = this.taskRepository.findById(id);
        if (optionalTask.isPresent()){
            Task task = optionalTask.get();
            task.setName(taskDTO.name);
            task.setDescription(taskDTO.description);
            this.taskRepository.save(task);
        }else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Task met dat id bestaat niet"
            );
        }
    }

    public void updateTaskStatus(long id, boolean finished) {
        Optional<Task> optionalTask = this.taskRepository.findById(id);
        if (optionalTask.isPresent()){
            Task task = optionalTask.get();
            task.setFinished(finished);
            this.taskRepository.save(task);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Task met dat id bestaat niet"
            );
        }
    }

//    public void checkTask(long id) {
//        Optional<Task> optionalTask = this.taskRepository.findById(id);
//        if (optionalTask.isPresent()) {
//            Task task = optionalTask.get();
//            task.setFinished(true);
//            this.taskRepository.save(task);
//        } else {
//            throw new ResponseStatusException(
//                    HttpStatus.NOT_FOUND, "Task met dat id bestaat niet"
//            );
//        }
//    }

//    public void uncheckTask(long id) {
//        Optional<Task> optionalTask = this.taskRepository.findById(id);
//        if (optionalTask.isPresent()) {
//            Task task = optionalTask.get();
//            task.setFinished(false);
//            this.taskRepository.save(task);
//        }else {
//            throw new ResponseStatusException(
//                    HttpStatus.NOT_FOUND, "Task met dat id bestaat niet"
//            );
//        }
//    }


}
