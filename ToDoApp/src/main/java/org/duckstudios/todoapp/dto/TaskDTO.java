package org.duckstudios.todoapp.dto;

public class TaskDTO {
    public String name;
    public String description;

    public TaskDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
