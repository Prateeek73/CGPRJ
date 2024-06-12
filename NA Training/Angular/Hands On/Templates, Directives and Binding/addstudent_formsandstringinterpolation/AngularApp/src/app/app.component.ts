import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  //IMPLEMENT YOUR CODE HERE
  title:string = 'Student Database';
  msg!:string;
  
  addNewStudent(name: string, reg: string, age: string) {
    //FILL YOU CODE HERE
    this.msg = `${name}-${reg}-${age}`;
  }
}
