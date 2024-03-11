package org.duckstudios.todoapp.utils;


import org.duckstudios.todoapp.dao.TaskRepository;
import org.duckstudios.todoapp.models.Task;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

// Seeder is om alles te testen

@Component
public class Seeder {

    private TaskRepository taskRepository;

    public Seeder(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

//  EventListener gaat af elke keer als spring opgestart wordt en maakt deze onderste 2 regels aan in de database
    @EventListener
    public void seed(ContextRefreshedEvent event) {
        Task task1 = new Task("Videos maken springboot", "maken van videos");
        Task task2 = new Task("Videos editen springboot", "editen van videos");

        this.taskRepository.save(task1);
        this.taskRepository.save(task2);
    }
}
