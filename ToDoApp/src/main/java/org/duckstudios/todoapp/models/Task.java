package org.duckstudios.todoapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// Je geeft hier aan dat dit een tabel gaat worden
// dus deze hele class wordt een tabel in de database
@Entity
public class Task {
//  Betekent dat dit een unieke id wordt in de database
    @Id
//  Betekent dat dit een auto generated id wordt dus stel je maakt
//  een nieuwe task dan wordt er plus 1 bij de id toegevoegd
    @GeneratedValue
    private long id;
    private String name;
    private String description;
    private boolean isFinished = false;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//  Lege constructor moet hier in staan anders werkt het niet
    public Task() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }
}
