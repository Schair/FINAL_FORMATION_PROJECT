package com.schairamaniega.pizzaproject.dao;

import java.util.List;

import com.schairamaniega.pizzaproject.entities.Pizza;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PizzaDAO extends JpaRepository<Pizza, Long> {
    
    @Query(value = "select p from Pizza p left join fetch p.ingredients")
    public List<Pizza> findAll(Sort sort);

    @Query(value = "select p from Pizza p left join fetch p.ingredients",
    countQuery = "select count(p) from Pizza p left join p.ingredients")
    public Page<Pizza> findAll(Pageable pageable);
}
