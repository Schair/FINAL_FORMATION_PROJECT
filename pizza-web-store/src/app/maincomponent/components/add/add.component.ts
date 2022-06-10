import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { tap } from 'rxjs';
import { Ingredient } from '../../interfaces/ingredient';
import { IngredientsService } from '../../services/ingredients.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.scss']
})
export class AddComponent implements OnInit {

  ingredients!: Ingredient[];

  ingredientsList = new FormControl('');

  constructor(private ingredientService: IngredientsService) { }

  ngOnInit(): void {
    this.ingredientService.getIngrendients().pipe(
      tap((ingredients: Ingredient[]) => this.ingredients = ingredients)
    ).subscribe();
  }

  printIngredients(){
    console.log(this.ingredientsList.value)
  }

  getToppingIngredients(){
    return this.ingredients.filter((ingredient: Ingredient) => ingredient.type == 0);
  }

  getCheese(){
    return this.ingredients.filter((ingredient: Ingredient) => ingredient.type == 3);
  }
}
