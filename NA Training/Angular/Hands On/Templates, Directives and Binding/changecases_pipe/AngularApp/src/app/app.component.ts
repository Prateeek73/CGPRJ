import { Component } from '@angular/core';
import { Student } from './Student.model'
//IMPORT STUDENT MODEL CLASS

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  title = 'Student-db';
  student: Student[] = [
    new Student('Sam', 'Rs200', 21),
    new Student('John', 'St001', 22),
    new Student('Ram', 'Rs021', 23),
    new Student('Angel', 'An021', 20)
  ];
}
