import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
    status!: string;
    title: string = 'Techzines';

    showStatus(){
        //Fill your code here
        this.status = 'Confirmation mail has been send to your mail id successfully';
    }
}
