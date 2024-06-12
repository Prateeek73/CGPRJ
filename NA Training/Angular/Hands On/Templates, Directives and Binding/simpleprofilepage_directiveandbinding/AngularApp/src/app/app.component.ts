import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
    //IMPLEMENT YOUR CODE HERE
    title = 'Profile Details';
    
    // profile: Profile  = {
    //   name: 'John',
    //   mail: 'John@jmail.com',
    //   contact: '123456789'
    // };
    name:string = 'John';
    mail:string = 'John@jmail.com';
    contact:string =  '123456789';
    editing:boolean = false;
  
    editProfile() {
      this.editing = true;
    }
  
    saveProfile() {
      this.editing = false;
    }
  }