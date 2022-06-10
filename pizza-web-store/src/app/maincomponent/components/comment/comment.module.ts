import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CommentComponent } from './comment.component';
import { MatCardModule } from '@angular/material/card';



@NgModule({
  declarations: [
    CommentComponent
  ],
  imports: [
    CommonModule,
    MatCardModule
  ],
  exports: [
    CommentComponent
  ]
})
export class CommentModule { }
