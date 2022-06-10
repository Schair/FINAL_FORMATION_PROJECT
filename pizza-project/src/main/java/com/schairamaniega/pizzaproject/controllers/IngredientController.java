package com.schairamaniega.pizzaproject.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.schairamaniega.pizzaproject.entities.Ingredient;
import com.schairamaniega.pizzaproject.hateoas.assemblers.IngredientModelAssembler;
import com.schairamaniega.pizzaproject.services.IngredientService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping(value = "/ingredients")
@RequiredArgsConstructor
public class IngredientController {
    
    @NonNull
    private final IngredientModelAssembler ingredientModelAssembler;

    @Autowired
    private IngredientService ingredientService;

    @GetMapping
    public CollectionModel<EntityModel<Ingredient>> getIngredients(){
        List<Ingredient> ingredients = null;

        ingredients = ingredientService.findAll();

        return CollectionModel.of(ingredients.stream().map(ingredientModelAssembler::toModel).collect(Collectors.toList()),
        linkTo(methodOn(IngredientController.class).getIngredients()).withSelfRel());

    }

    @GetMapping(value = "/{id}")
    public EntityModel<Ingredient> findById(@PathVariable(name = "id") long id) {
        return ingredientModelAssembler.toModel(ingredientService.findById(id));
    }

}
