import { Component, OnInit } from '@angular/core';
import { Book } from './Book';
import { BookService } from './book.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'SearchBook';

  

  constructor(private bookService: BookService) {}

  ngOnInit(): void {
    
  }

  
}
