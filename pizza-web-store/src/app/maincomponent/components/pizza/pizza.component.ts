import { Component, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Ingredient } from '../../interfaces/ingredient';
import { Pizza } from '../../interfaces/pizza';

@Component({
  selector: 'app-pizza',
  templateUrl: './pizza.component.html',
  styleUrls: ['./pizza.component.scss']
})
export class PizzaComponent implements OnInit {

  @Input() pizza!: Pizza;
  // TODO: Generate output
  //@Output()

  ingredients!: Ingredient[];
  ingredientsString!: string;

  constructor(private router: Router) { }

  ngOnInit(): void { 
    this.ingredients = this.pizza.ingredients;
  }

  getUrl(){
    return "/assets/img/" + this.pizza.img;
  }
  getDough(){
    return this.ingredients.filter(ingredient => ingredient.type == 1);
  }

  getIngredientsString(){
    this.pizza.ingredients.filter(ingredient => ingredient.type != 1).forEach(element => {
      this.ingredientsString += element.name + ", ";
    });

    return this.ingredientsString;
  }

  cardClick(id: number){
    this.router.navigateByUrl('pizzas/details/' + id);
  }
}
