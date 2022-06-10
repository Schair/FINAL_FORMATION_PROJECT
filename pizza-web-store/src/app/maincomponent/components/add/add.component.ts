import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
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

  ingredientsToSend!: Ingredient[];

  pizzaForm!: FormGroup;

  constructor(private ingredientService: IngredientsService, public formBuiler: FormBuilder, private http: HttpClient) { }

  ngOnInit(): void {
    this.ingredientService.getIngrendients().pipe(
      tap((ingredients: Ingredient[]) => this.ingredients = ingredients)
    ).subscribe();

    this.pizzaForm = this.formBuiler.group({
      name: [''],
      dough: [''],
      toppings: ['']
    });
  }
  
  getIngredients() {
    return this.ingredients.filter((ingredient: Ingredient) => ingredient.type != 1);
  }

  getDough() {
    return this.ingredients.filter((ingredient: Ingredient) => ingredient.type == 1);
  }

  test(){
    console.log('Hola');

    var pizzaData: any = new FormData();
    pizzaData.append('name', this.pizzaForm.get('name')?.value);
    this.ingredientsToSend = this.pizzaForm.get('toppings')?.value;
    pizzaData.append('ingredients', this.pizzaForm.get('dough')?.value);
    pizzaData.append('img', "default.webp");

    console.log(this.pizzaForm.get('toppings')?.value);
    
    this.http.post("http://localhost:8080/pizzas/add", pizzaData).subscribe({
      next: (response) => console.log(response),
      error: (error) => console.log(error)
    });

    // window.location.reload()
  }
}
