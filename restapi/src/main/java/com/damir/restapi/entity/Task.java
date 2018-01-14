package com.damir.restapi.entity;

public class Task {

    private int id;
    private String name;
    private String task;
    private Boolean completed = false;

    public Task(int id, String name, String task) {
        this.id = id;
        this.name = name;
        this.task = task;
    }

    public Task(int id, String name, String task, Boolean completed) {
        this.id = id;
        this.name = name;
        this.task = task;
        this.completed = completed;
    }

    public Task() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }


    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}

