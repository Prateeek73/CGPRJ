//Implement your code here
import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { Student } from '../Student.model';

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css'],
})
export class AddStudentComponent implements OnInit {
  @Output() onSubmit:EventEmitter<String> = new EventEmitter<Student>();

  student: Student = new Student('', '', 0);

  ngOnInit(): void {
    this.onSubmit.emit(this.student);
    this.student = new Student('', '', 0);
  }

  constructor() {}
}
