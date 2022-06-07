import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PizzasRoutingModule } from './pizzas-routing.module';
import { PizzasComponent } from './pizzas.component';
import { PizzaComponent } from '../pizza/pizza.component';

import { HttpClientModule } from '@angular/common/http';
import {MatCardModule} from '@angular/material/card';
import {MatGridListModule} from '@angular/material/grid-list';



@NgModule({
  declarations: [
    PizzasComponent,
    PizzaComponent
  ],
  imports: [
    CommonModule,
    PizzasRoutingModule,
    HttpClientModule,
    MatCardModule,
    MatGridListModule
  ],
  exports: [
    PizzaComponent,
    PizzasComponent
  ]
})
export class PizzasModule { }
