import { Component } from '@angular/core';
//IMPORT STUDENT MODEL CLASS
import { Student } from './Student.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  //Assign the Student details to the variable student which is type Student[].
  title = 'Student-db';
  student: Student[] = [
    new Student('Sam', 'Rs200', 21),
    new Student('John', 'St001', 22),
    new Student('Angel', 'An021', 20)
  ]; 
}