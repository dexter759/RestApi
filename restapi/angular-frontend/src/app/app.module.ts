import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {TaskListComponent} from "./task-list.component";
import {FormsModule} from "@angular/forms";
import {TaskService} from "./task.service";
import {HttpClientModule} from "@angular/common/http";
import {HttpModule} from "@angular/http";




@NgModule({
  declarations: [
    AppComponent,
    TaskListComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    HttpModule
  ],
  providers: [TaskService],
  bootstrap: [AppComponent]
})
export class AppModule { }
