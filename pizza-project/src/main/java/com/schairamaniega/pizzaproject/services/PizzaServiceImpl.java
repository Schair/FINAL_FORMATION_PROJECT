package com.schairamaniega.pizzaproject.services;

import java.util.List;

import com.schairamaniega.pizzaproject.dao.PizzaDAO;
import com.schairamaniega.pizzaproject.entities.Pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PizzaServiceImpl implements PizzaService {

    @Autowired
    private PizzaDAO pizzaDAO;

    @Override
    public List<Pizza> findAll(Sort sort) {
        return this.pizzaDAO.findAll(sort);
    }

    @Override
    public Pizza save(Pizza pizza) {
        return this.pizzaDAO.save(pizza);
    }

    @Override
    public Pizza findById(Long id) {
        return this.pizzaDAO.findById(id).get();
    }

    @Override
    public Page<Pizza> findAll(Pageable pageable) {
        return this.pizzaDAO.findAll(pageable);
    }
    
}
