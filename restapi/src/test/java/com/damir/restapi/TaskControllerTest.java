package com.damir.restapi;

import com.damir.restapi.controller.TaskController;
import com.damir.restapi.entity.Task;
import com.damir.restapi.service.TaskService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;


import java.util.Collection;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@WebMvcTest(controllers= TaskController.class)
public class TaskControllerTest{



    @MockBean
    private TaskService taskService;

    
    @Before
    public void setUp(){
        taskService=new TaskService();
    }

    @Test
    public void should_load_all_tasks()
    {
        Collection<Task> taskList = taskService.getAllTasks();
        assertNotNull(taskList);
        assertEquals(3, taskList.size());

    }

    @Test
    public void should_load_one_task(){

        Task task = taskService.getTaskById(1);
        assertNotNull(task);
        assertEquals(1,task.getId());
        assertEquals("Go to meeting", task.getName());
        assertEquals("Have a meal at Hotel plaza with Obama", task.getTask());
    }

    @Test
    public void should_upload_one_task(){
        Task task = new Task(4,"Christmas Party","Take some presents for colleges","04-12-2018");
        taskService.insertTask(task);

        Task testTask = taskService.getTaskById(4);

        assertNotNull(testTask);
        assertEquals(4,testTask.getId());
        assertEquals("Christmas Party", testTask.getName());
        assertEquals("Take some presents for colleges", testTask.getTask());
        assertEquals("04-12-2018",testTask.getDate());

    }

    @Test
    public void should_update_one_task(){
        Task task = new Task(1,"Work","Work work work","04-12-2018");
        taskService.updateTask(task);


        Task testTask = taskService.getTaskById(1);

        assertNotNull(testTask);
        assertEquals(1,testTask.getId());
        assertEquals("Work", testTask.getName());
        assertEquals("Work work work", testTask.getTask());
        assertEquals("04-12-2018",testTask.getDate());

    }

    @Test
    public void should_delete_one_task() {
        Collection<Task> taskCollection = taskService.getAllTasks();
        int taskCollectionSize = taskCollection.size();
        taskService.deleteTaskById(3);

        taskCollection = taskService.getAllTasks();

        assertNotNull(taskCollection);
        assertEquals(taskCollectionSize - 1, taskCollection.size());
    }

}