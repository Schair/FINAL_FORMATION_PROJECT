import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, Observable, tap } from 'rxjs';
import { Pizza } from '../interfaces/pizza';
import { PizzasResponse } from '../interfaces/pizzas-response';

@Injectable({
  providedIn: 'root'
})
export class PizzasService {

  private apiURL: string = "http://localhost:8080/pizzas"

  constructor(private http: HttpClient) { }

  getPizzas() : Observable<Pizza[]>{
    return this.http.get<PizzasResponse>(this.apiURL).pipe(map(response => response._embedded.pizzaList));
  }
}
