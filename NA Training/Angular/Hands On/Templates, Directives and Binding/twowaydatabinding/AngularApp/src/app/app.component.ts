import { Component, OnInit, EventEmitter, Output} from '@angular/core';
import { Student } from './Student.model';

// Fill you code to import Student.model.ts


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  
  // Fill your code here
  student:Student = new  Student("", "", 0);
  ngOnInit(){}

  submitForm(student: Student) {
    // You can add logic here to handle the form submission,
    // such as sending the data to a server or performing further actions.
    this.student = student;
   }
}