import { TextFieldModule } from '@angular/cdk/text-field';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatGridListModule } from '@angular/material/grid-list';
import { DetailsRoutingModule } from './details-routing.module';
import { DetailsComponent } from './details.component';
import { CommentModule } from '../comment/comment.module';
import { MatButtonModule } from '@angular/material/button';

@NgModule({
  declarations: [
    DetailsComponent
  ],
  imports: [
    CommonModule,
    DetailsRoutingModule,
    MatGridListModule,
    MatCardModule,
    MatFormFieldModule,
    TextFieldModule,
    CommentModule,
    MatButtonModule
  ],
  exports: [
    DetailsComponent,
    MatFormFieldModule
  ]
})
export class DetailsModule { }
