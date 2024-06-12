import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  //ADD TEMPLATE URL TO HTML FILE
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
    //IMPLEMENT YOUR CODE HERE
  title = 'Login Form';
  
  showLoginForm: boolean = true;
  
  toggleForm() {
      this.showLoginForm = !this.showLoginForm;
  }
}
