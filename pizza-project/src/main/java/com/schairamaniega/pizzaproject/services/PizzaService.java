package com.schairamaniega.pizzaproject.services;

import java.util.List;

import com.schairamaniega.pizzaproject.entities.Pizza;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface PizzaService {

    public List<Pizza> findAll();
    
    public List<Pizza> findAll(Sort sort);

    public Page<Pizza> findAll(Pageable pageable);

    public Pizza findById(Long id);

    public Pizza save(Pizza pizza);
    
}
