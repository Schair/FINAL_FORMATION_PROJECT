package com.schairamaniega.pizzaproject.hateoas.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.schairamaniega.pizzaproject.controllers.IngredientController;
import com.schairamaniega.pizzaproject.entities.Ingredient;

@Component
public class IngredientModelAssembler implements RepresentationModelAssembler<Ingredient, EntityModel<Ingredient>>{

    @Override
    public EntityModel<Ingredient> toModel(Ingredient entity) {

        return EntityModel.of(entity, linkTo(methodOn(IngredientController.class).findById(entity.getId())).withSelfRel(),
        linkTo(methodOn(IngredientController.class).getIngredients()).withRel("ingredients"));

    }
}
