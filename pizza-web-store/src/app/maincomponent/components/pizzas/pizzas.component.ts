import { Component, OnInit } from '@angular/core';
import { tap } from 'rxjs';
import { Pizza } from '../../interfaces/pizza';
import { PizzasService } from '../../services/pizzas.service';

@Component({
  selector: 'app-pizzas',
  templateUrl: './pizzas.component.html',
  styleUrls: ['./pizzas.component.scss'],
})
export class PizzasComponent implements OnInit {

  pizzas!: Pizza[];

  constructor(private pizzaService: PizzasService) { }

  ngOnInit(): void {

    this.pizzaService.getPizzas().pipe(
      tap((pizzas: Pizza[]) => this.pizzas = pizzas)
    ).subscribe();
  }

}
