//Implement Your Code Here

import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  //Implement code here
  token: number = 0;
  title: string = 'Token Generator';
  constructor() {
    this.token = 100;
  }

  clicked() {
    this.token++;
  }
}
