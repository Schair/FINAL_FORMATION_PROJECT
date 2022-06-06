package com.schairamaniega.pizzaproject.hateoas.assemblers;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.schairamaniega.pizzaproject.controllers.PizzaController;
import com.schairamaniega.pizzaproject.entities.Pizza;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class PizzaModelAssembler implements RepresentationModelAssembler<Pizza, EntityModel<Pizza>>{

    @Override
    public EntityModel<Pizza> toModel(Pizza entity) {

        return EntityModel.of(entity, linkTo(methodOn(PizzaController.class).findById(entity.getId())).withSelfRel(), 
        linkTo(methodOn(PizzaController.class).getPizzas(1, 3)).withRel("pizzas"));

    }
    
}
