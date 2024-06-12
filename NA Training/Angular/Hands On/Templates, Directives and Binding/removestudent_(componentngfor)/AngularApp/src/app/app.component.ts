import { Component } from '@angular/core';
import { Student } from './Student.model';
//IMPORT STUDENT MODEL CLASS

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  //Assign the Student details to the variable student which is type Student[].
  title = 'Student-db';
  student: Student[] = [
    new Student('Sam', 'RS200', 21),
    new Student('John', 'ST001', 22),
    new Student('Ram', 'RS201', 23),
    new Student('Angel', 'AN021', 20)
  ]; 

  deleteStudent(stud: Student){
    const index = this.student.indexOf(stud);
    if (index !== -1) {
      this.student.splice(index, 1);
    }
  }
}
