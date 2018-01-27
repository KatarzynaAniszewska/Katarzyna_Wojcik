package com.kodilla.hibernate.task;

import com.kodilla.hibernate.task.dao.TaskDao;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="TASKS")

public class Task{

    private int Id;
    private String description;
    private Date created;
    private int duration;

    public Task(String description, int duration) {
        this.description = description;
        this.duration = duration;
        this.created=new Date();
    }
    @Id
    @GeneratedValue
    @NotNull
    @Column(name="ID",unique = true)

    public int getId() {
        return Id;
    }
    @NotNull
    @Column(name="DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public Date getCreated() {
        return created;
    }

    @Column(name="DURATION")
    public int getDuration() {
        return duration;
    }

    private void setId(int id) {
        Id = id;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    private void setCreated(Date created) {
        this.created = created;
    }

    private void setDuration(int duration) {
        this.duration = duration;
    }
}
