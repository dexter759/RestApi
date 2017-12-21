package com.damir.restapi.Service;


import com.damir.restapi.Dao.TaskDao;
import com.damir.restapi.Entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TaskService {

    @Autowired
    @Qualifier("MySqlData")
    private TaskDao taskDao;

    public Collection<Task> getAllTasks(){
        return this.taskDao.getAllTasks();
    }

    public Task getTaskById(int id){
        return this.taskDao.getTaskById(id);
    }

    public void deleteTaskById(int id) {
        this.taskDao.deleteTaskById(id);
    }

    public void updateTask(Task task){
        this.taskDao.updateTask(task);

    }

    public void insertTask(Task task) {
        this.taskDao.insertTask(task);
    }
}
