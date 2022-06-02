package com.schairamaniega.pizzaproject.services;

import java.util.List;

import com.schairamaniega.pizzaproject.entities.Pizza;

import org.springframework.data.domain.Sort;

public interface PizzaService {
    
    public List<Pizza> findAll(Sort sort);

    public Pizza save(Pizza pizza);
    
}
