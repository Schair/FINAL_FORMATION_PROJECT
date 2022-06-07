export interface Pizza {
    id: number;
    name: string;
    img: string;
    comments?: {
        id: number;
        body: string;
        score: number;
        user: string;
    };
    price: number;
    ingredients: {
        id: number;
        name: string;
        price: number;
        type: number;
    };

}
