import { Pizza } from "./pizza";

export interface PizzasResponse {
    _embedded: {
        pizzaList: Pizza[];
        _links: {self: {href: string}};
    };
}
