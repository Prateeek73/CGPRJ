//Implement your code here
import { Component,Input } from '@angular/core';
//Import Student model class
import { Student } from './Student.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

student: Student[] = [
    new Student('Sam', 'RS200', 21),
    new Student('John', 'ST001', 22),
    new Student('Angel', 'AN021', 20)
    ];

addStudent(student: Student) {
    this.student.push(student);
}
  //Implement your code here
    constructor(){

    }

    title = 'Student-db';
}
	 	  	  		  	     	     	       	 	
