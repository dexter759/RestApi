package com.damir.restapi.dao;

import com.damir.restapi.entity.Task;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Qualifier("fakeData")
public class FakeTaskDaoImpl implements TaskDao {

    private static Map<Integer, Task> tasks;

    static {

        tasks = new HashMap<Integer, Task>(){

            {
                put(1,new Task(1,"Go to meeting","Have a meal at Hotel plaza with Obama"));
                put(2,new Task(2,"Go to dentist","Go to Dentist near avenue mall"));
                put(3,new Task(3,"Cook fries","Pls don't forget to buy potatoes"));
            }
        };
    }

    @Override
    public Collection<Task> getAllTasks(){
        return this.tasks.values();
    }

    @Override
    public Task getTaskById(int id){
        return this.tasks.get(id);
    }

    @Override
    public void deleteTaskById(int id) {
        this.tasks.remove(id);
    }

    @Override
    public void updateTask(Task task){

        Task oneTask = tasks.get(task.getId());
        oneTask.setName(task.getName());
        oneTask.setTask(task.getTask());
        tasks.put(task.getId(), oneTask);

    }

    @Override
    public void insertTask(Task task) {
        this.tasks.put(task.getId(),task);
    }
}
