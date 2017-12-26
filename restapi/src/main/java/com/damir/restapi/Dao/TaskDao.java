package com.damir.restapi.dao;

import com.damir.restapi.entity.Task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface TaskDao {
    Collection<Task> getAllTasks();

    Task getTaskById(int id);

    void deleteTaskById(int id);

    void updateTask(Task task);

    void insertTask(Task task);
}
