import { Component, OnInit, Input, Output, EventEmitter  } from '@angular/core';
import { Book } from '../Book';
import { BookService } from '../book.service';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {
 
  constructor(private bookService: BookService) { }

  books: any[] = [];

  logData: string = '';
  criteria: string = 'Book Name';
  searchText: string = '';
 
  ngOnInit(): void {
        // fill the code
        const data: string[] = this.bookService.getLogData();
        this.logData = data[0];
        console.log(data);
  }

 
  searchBooks() {
    this.books = [];

    if(this.criteria === 'Book Name') {
      this.books = this.bookService.searchByBookName(this.searchText);
    } else if(this.criteria === 'Category') {
      this.books = this.bookService.searchByCategory(this.searchText);
    }
  }

}
