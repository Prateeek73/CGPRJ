import { Component } from '@angular/core';
//IMPORT STUDENT MODEL CLASS
import {Student} from './Student.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'Student-db';
  student: Student[] = [
    new Student('Sam', 'RS200', 21),
    new Student('John', 'ST001', 22),
    new Student('Ram', 'RS021', 23),
    new Student('Angel', 'AN021', 20)
  ];

}
