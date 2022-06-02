package com.schairamaniega.pizzaproject.dao;

import java.util.List;

import com.schairamaniega.pizzaproject.entities.Ingredient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientDAO extends JpaRepository<Ingredient, Long>{

}
