package com.damir.restapi.Entity;

public class Task {

    private int id;
    private String name;
    private String task;

    public Task(int id, String name, String task) {
        this.id = id;
        this.name = name;
        this.task = task;
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
}
