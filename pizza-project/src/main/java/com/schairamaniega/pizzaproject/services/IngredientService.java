package com.schairamaniega.pizzaproject.services;

import java.util.List;

import com.schairamaniega.pizzaproject.entities.Ingredient;

public interface IngredientService {

    public List<Ingredient> findAll();

    public Ingredient findById(Long id);

    public Ingredient save(Ingredient ingredient);

}
