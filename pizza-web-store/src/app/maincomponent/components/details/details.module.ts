import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DetailsRoutingModule } from './details-routing.module';
import { DetailsComponent } from './details.component';

import { MatGridListModule } from '@angular/material/grid-list';
import { MatCardModule } from '@angular/material/card';


export interface Tile {
  color: string;
  cols: number;
  rows: number;
  text: string;
}

@NgModule({
  declarations: [
    DetailsComponent
  ],
  imports: [
    CommonModule,
    DetailsRoutingModule,
    MatGridListModule,
    MatCardModule
  ],
  exports: [
    DetailsComponent
  ]
})
export class DetailsModule { }
