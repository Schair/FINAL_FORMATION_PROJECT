import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Pizza } from '../../interfaces/pizza';
import { PizzasService } from '../../services/pizzas.service';

import { BreakpointObserver } from '@angular/cdk/layout';

export interface Tile {
  color: string;
  cols: number;
  rows: number;
  text: string;
}

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.scss']
})
export class DetailsComponent implements OnInit {

  id!: number;
  pizza!: Pizza;
  mobile!: boolean;

  tiles: Tile[] = [
    {text: `One`, cols: 3, rows: 1, color: 'lightblue'},
    {text: 'Two', cols: 1, rows: 2, color: 'lightgreen'},
    {text: 'Three', cols: 1, rows: 1, color: 'lightpink'},
    {text: 'Four', cols: 2, rows: 1, color: '#DDBDF1'},
  ];

  constructor(private route: ActivatedRoute, private pizzaService: PizzasService, private observer: BreakpointObserver) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.pizzaService.getPizza(this.route.snapshot.params['id']).subscribe((pizza: Pizza) => this.pizza = pizza);
  }

  ngAfterViewInit(){
    this.observer.observe(['(max-width: 800px)']).subscribe((res) => {
      this.mobile = res.matches;
    });
  }

}
