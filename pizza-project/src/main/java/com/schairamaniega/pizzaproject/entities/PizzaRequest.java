package com.schairamaniega.pizzaproject.entities;

import lombok.Data;

@Data
public class PizzaRequest {
    private long id;
    private String name;
    private String img;
    private int[] ingredients;

}
