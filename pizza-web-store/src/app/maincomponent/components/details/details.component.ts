import { Component, OnInit, NgZone, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Pizza } from '../../interfaces/pizza';
import { PizzasService } from '../../services/pizzas.service';

import { BreakpointObserver } from '@angular/cdk/layout';

import { FormGroup, FormBuilder } from '@angular/forms';

import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.scss']
})
export class DetailsComponent implements OnInit {

  id!: number;
  pizza!: Pizza;
  mobile!: boolean;

  commentForm: FormGroup;

  constructor(private route: ActivatedRoute, private pizzaService: PizzasService, 
    private observer: BreakpointObserver, public formBuilder: FormBuilder, private http: HttpClient) {
      this.commentForm = this.formBuilder.group({
        body: [''],
        score: [''],
        pizza_id: [this.id],
        user: ['']
      });
    }

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

  submitComment(){

    var commentData: any = new FormData();
    commentData.append('user', "default");
    commentData.append('score', this.commentForm.get('score')?.value);
    commentData.append('body', this.commentForm.get('body')?.value);

    console.log(this.commentForm.get('body')?.value);

    this.http.post(`http://localhost:8080/details/${this.id}`, commentData).subscribe({
      next: (response) => console.log(response),
      error: (error) => console.log(error)
    });

    window.location.reload()

  }

}
