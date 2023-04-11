import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { AuthorComponent } from './author/author.component';
import { BookComponent } from './book/book.component';
import { LoanComponent } from './loan/loan.component';
import { PublisherComponent } from './publisher/publisher.component';
import { StudentComponent } from './student/student.component';
import { AddBookComponent } from './add-book/add-book.component';

const routes: Routes = [
  {
    path: 'book',
    component : BookComponent,
  },
  {
    path: 'admin',
    component: AdminComponent,
  },
  {
    path: 'loan',
    component : LoanComponent,
  },
  {
    path: 'publisher',
    component : PublisherComponent,
  },
  {
    path: 'author',
    component : AuthorComponent,
  },
  {
    path: 'student',
    component : StudentComponent,
  },
  {
    path: 'add-book',
    component : AddBookComponent,
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
