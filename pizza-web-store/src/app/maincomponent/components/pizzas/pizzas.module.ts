import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { PizzaComponent } from '../pizza/pizza.component';
import { PizzasRoutingModule } from './pizzas-routing.module';
import { PizzasComponent } from './pizzas.component';


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
    MatButtonModule
  ],
  exports: [
    PizzaComponent,
    PizzasComponent
  ]
})
export class PizzasModule { }
