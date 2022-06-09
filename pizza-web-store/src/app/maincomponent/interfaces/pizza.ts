import { Comment } from "./comment";
import { Ingredient } from "./ingredient";

export interface Pizza {
    id: number;
    name: string;
    img: string;
    // comments?: {
    //     id: number;
    //     body: string;
    //     score: number;
    //     user: string;
    // };
    comments?: Comment[];
    price: number;
    // ingredients: {
    //     id: number;
    //     name: string;
    //     price: number;
    //     type: number;
    // };
    ingredients: Ingredient[];
}
