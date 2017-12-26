package com.damir.restapi.controller;


import com.damir.restapi.entity.Task;
import com.damir.restapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;


@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Task> getAllStudents(){
        return taskService.getAllTasks();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Task getTaskById(@PathVariable("id") int id){
        return taskService.getTaskById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTaskById(@PathVariable("id") int id){
        taskService.deleteTaskById(id);
    }
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void editTask(@RequestBody Task task){
        taskService.updateTask(task);
    }
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertTask(@RequestBody Task task){
        taskService.insertTask(task);
    }


}
