import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class BookService {

  public BASE_URL:string=" http://localhost:8080";
  constructor(private http:HttpClient) { }

  getBooks(){
    return this.http.get(`${this.BASE_URL}/books/getAll`);
  }
  addBook(data:any){
    return this.http.post(`${this.BASE_URL}/books/saveBook`,data);
  }
  deleteBook(id:any){
    console.log(id)
    return this.http.delete(`${this.BASE_URL}/books/delete/${id}`);
  }
}
