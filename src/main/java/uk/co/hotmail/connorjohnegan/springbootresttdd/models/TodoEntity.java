package uk.co.hotmail.connorjohnegan.springbootresttdd.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@Entity
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String task;
    private Instant creationDate;
    private boolean complete;

    public TodoEntity(String task, Instant creationDate, boolean complete) {
        this.task = task;
        this.creationDate = creationDate;
        this.complete = complete;
    }

    public Long getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public boolean isComplete() {
        return complete;
    }
}
