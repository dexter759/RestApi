package com.damir.restapi.service;



import com.damir.restapi.dao.FakeTaskDaoImpl;
import com.damir.restapi.dao.MySqlTaskDaoImpl;
import com.damir.restapi.dao.TaskDao;
import com.damir.restapi.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class TaskService {

    @Autowired
    @Qualifier("MySqlData")
    private TaskDao taskDao;

    public TaskService() {
        taskDao = new FakeTaskDaoImpl();
    }

    @Cacheable("tasks")
    public Collection<Task> getAllTasks(){
        return this.taskDao.getAllTasks();
    }

    @Cacheable("task")
    public Task getTaskById(int id){
        return this.taskDao.getTaskById(id);
    }

    @Caching(evict = {
            @CacheEvict(value = "tasks", allEntries = true),
            @CacheEvict(value = "task", allEntries = true)})
    public void deleteTaskById(int id) {
        this.taskDao.deleteTaskById(id);
    }

    @Caching(evict = {
            @CacheEvict(value = "tasks", allEntries = true),
            @CacheEvict(value = "task", allEntries = true)})
    public void updateTask(Task task){
        this.taskDao.updateTask(task);
    }

    @CacheEvict(value = "tasks", allEntries = true)
    public void insertTask(Task task) {
        this.taskDao.insertTask(task);
    }
}
