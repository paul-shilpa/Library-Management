import { Component, OnInit } from '@angular/core';
import { BookService } from '../service/book.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {

  

  ngOnInit(): void {
  }
  data={
    title:"",
    author:"",
    isbn:"",
    publisher:"",
    copies:"",
    category:"",
    genre:"",
    subgenre:"",
  }
  flag=true;
  reset(){
    this.data={
      title:"",
      author:"",
      isbn:"",
      publisher:"",
      copies:"",
      category:"",
      genre:"",
      subgenre:"",
    }
  }
  constructor(private email:BookService,private router:Router){}
  doSubmitForm(){
    console.log("Data",this.data);
    if(this.data.title =='' || this.data.author == '' || this.data.isbn == '' || this.data.category == '' || this.data.publisher=='' ||
    this.data.genre=='' || this.data.copies=='' ||this.data.subgenre=='')
    {
      alert("feilds can not be empty !!,OK");
      return;
    }
    this.flag=false;
    this.email.addBook(this.data).subscribe(
      (response:any) => {
        console.log(response);
        this.reset();
        this.flag=true;

        this.router.navigate(['book']);
        // alert(response.token)
      },
      (error:any) => {
        console.log(error);
        this.reset();
        this.flag=true;
        alert("Something Went Wrong!!");
      }
    )
  }
}
