package com.damir.restapi.Dao;

import com.damir.restapi.Entity.Task;

import java.util.Collection;

public interface TaskDao {
    Collection<Task> getAllTasks();

    Task getTaskById(int id);

    void deleteTaskById(int id);

    void updateTask(Task task);

    void insertTask(Task task);
}
