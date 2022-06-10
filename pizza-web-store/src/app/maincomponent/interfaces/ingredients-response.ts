import { Ingredient } from "./ingredient";

export interface IngredientsResponse {
    _embedded: {
        ingredientList: Ingredient[];
        _links: {self: {href: string}};
    };
}
