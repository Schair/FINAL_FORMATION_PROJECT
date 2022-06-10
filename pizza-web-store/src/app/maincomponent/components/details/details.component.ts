import { Component, OnInit, NgZone, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Pizza } from '../../interfaces/pizza';
import { PizzasService } from '../../services/pizzas.service';

import { BreakpointObserver } from '@angular/cdk/layout';

import { FormGroup, FormControl } from '@angular/forms';


@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.scss']
})
export class DetailsComponent implements OnInit {

  id!: number;
  pizza!: Pizza;
  mobile!: boolean;

  commentForm = new FormGroup({
    body: new FormControl(''),
  });

  constructor(private route: ActivatedRoute, private pizzaService: PizzasService, 
    private observer: BreakpointObserver) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.pizzaService.getPizza(this.route.snapshot.params['id']).subscribe((pizza: Pizza) => this.pizza = pizza);
  }

  ngAfterViewInit(){
    this.observer.observe(['(max-width: 800px)']).subscribe((res) => {
      this.mobile = res.matches;
    });
  }

  getIngredients(){
    return this.pizza.ingredients.filter(ingredient => ingredient.type != 1);
  }
  getDough(){
    return this.pizza.ingredients.filter(ingredient => ingredient.type == 1);
  }

  commentSubmit() {
    console.log(this.commentForm);
  }

}
