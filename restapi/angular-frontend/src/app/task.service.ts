import {Injectable, Inject} from '@angular/core';
import {Http,RequestOptions, Request, Headers} from '@angular/http';
import {Task} from './task';
import 'rxjs/add/operator/map'
import {HttpClient} from "@angular/common/http";


@Injectable()
export class TaskService {
  private baseUrl = 'http://localhost:8080';
  constructor(public http: Http) {}

  getTasks(): Promise<Task[]>{
    return this.http.get(this.baseUrl+'/api/tasks')
      .toPromise()
      .then(response => response.json() as Task)
      .catch(this.handleError);
  }

  createTask(taskData: Task): Promise<Task> {
    return this.http.post(this.baseUrl + '/api/tasks', taskData)
      .toPromise()
      .catch(this.handleError);
  }

  updateTask(taskData: Task): Promise<Task> {
    return this.http.put(this.baseUrl + '/api/tasks/', taskData)
      .toPromise()
      .catch(this.handleError);
  }

  deleteTask(id: number): Promise<any> {
    return this.http.delete(this.baseUrl + '/api/tasks/' + id)
      .toPromise()
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('Some error occured', error);
    return Promise.reject(error.message || error);
  }


}
