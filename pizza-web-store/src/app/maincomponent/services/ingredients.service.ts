import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Ingredient } from '../interfaces/ingredient';
import { IngredientsResponse } from '../interfaces/ingredients-response';

@Injectable({
  providedIn: 'root'
})
export class IngredientsService {

  private apiURL: string = "http://localhost:8080/ingredients";

  constructor(private http: HttpClient) { }

  getIngrendients() : Observable<Ingredient[]> {
    return this.http.get<IngredientsResponse>(this.apiURL).pipe(map(response => response._embedded.ingredientList));
  }
}
