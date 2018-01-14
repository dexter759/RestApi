import {Component, OnInit, Input} from '@angular/core'
import { Task } from './task';
import {NgForm} from "@angular/forms";
import {TaskService} from "./task.service";
import {log} from "util";


@Component({
  selector: 'task-list',
  templateUrl: './task-list.component.html'
})

export class TaskListComponent implements OnInit{
  tasks:Task[];
  newTask: Task = new Task();
  editing: boolean = false;
  editingTask: Task = new Task();

  constructor(
    private taskService: TaskService,
  ) {}

  ngOnInit(): void{
    this.getTask();
  }

  getTask(): void{
    this.taskService.getTasks()
      .then(tasks => this.tasks = tasks);
  }

  createTask(taskForm: NgForm):void{
    console.log(this.newTask);
    this.newTask.completed=false
    this.taskService.createTask(this.newTask)
      .then(createTask =>{
        taskForm.reset();
        this.newTask = new Task();

        this.tasks.unshift(createTask);
        this.ngOnInit();
    });
  }
  deleteTask(id: number): void {
    this.taskService.deleteTask(id)
      .then(()=>{
        this.tasks = this.tasks.filter(task => task.id !=id);
      });
  }

  updateTask(taskData: Task): void {
    console.log(taskData);
    this.taskService.updateTask(taskData)
      .then(updatedTask => {
        let existingTask = this.tasks.find(task => task.id === taskData.id);
        console.log(existingTask);
        console.log(updatedTask);
        Object.assign(existingTask, updatedTask);
        this.clearEditing();
        this.ngOnInit();
      });
  }

  toggleCompleted(taskData: Task): void {
    taskData.completed = !taskData.completed;
    this.taskService.updateTask(taskData)
      .then(updatedTask =>{
        let existingTask = this.tasks.find(task=> task.id === taskData.id);
        console.log(existingTask);
        console.log(updatedTask);
        Object.assign(existingTask, updatedTask);
        this.ngOnInit();
      });

  }

  editTask(taskData: Task): void {
  this.editing = true;
  Object.assign(this.editingTask, taskData);
  this.ngOnInit();

  }

  clearEditing(): void {
    this.editingTask = new Task();
    this.editing = false;
  }
}
