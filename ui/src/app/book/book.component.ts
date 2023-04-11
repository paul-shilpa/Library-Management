import { Component, OnInit } from '@angular/core';
import { BookService } from '../service/book.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {
  books: any = [];
  constructor(private book:BookService,private router:Router) { }


  ngOnInit(): void {
    this.getAllBooks()
  }
  ngAfterViewInit() {this.getAllBooks()}
  getAllBooks(){
    this.book.getBooks().subscribe((res)=>{
      this.books=res
      console.log(res)
    },
    (error)=>{
      console.log(error)
    }
    )
  }
  doDelete(id:any){
    console.log(id)
    this.book.deleteBook(id).subscribe((res)=>{
      this.ngOnInit();
    },
    (error)=>{
      console.log(error)
    }
    )
  }
  
}
