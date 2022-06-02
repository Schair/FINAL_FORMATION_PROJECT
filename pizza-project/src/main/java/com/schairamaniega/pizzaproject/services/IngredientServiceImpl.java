package com.schairamaniega.pizzaproject.services;

import java.util.List;

import com.schairamaniega.pizzaproject.dao.IngredientDAO;
import com.schairamaniega.pizzaproject.entities.Ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientServiceImpl implements IngredientService{

    @Autowired
    private IngredientDAO ingredientDAO;

    @Override
    public List<Ingredient> findAll() {
        return this.ingredientDAO.findAll();
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return this.ingredientDAO.save(ingredient);
    }

    @Override
    public Ingredient findById(Long id) {
        return this.ingredientDAO.findById(id).get();
    }
    
}
