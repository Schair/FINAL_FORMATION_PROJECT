package com.schairamaniega.pizzaproject.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.schairamaniega.pizzaproject.entities.Pizza;
import com.schairamaniega.pizzaproject.hateoas.assemblers.PizzaModelAssembler;
import com.schairamaniega.pizzaproject.services.PizzaService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/pizzas")
@RequiredArgsConstructor
public class PizzaController {
    
    @NonNull
    private final PizzaModelAssembler pizzaModelAssembler;

    @Autowired
    private PizzaService pizzaService;

    @GetMapping
    public CollectionModel<EntityModel<Pizza>> getPizzas(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size){

        Sort sortByName = Sort.by("name");

        List<Pizza> pizzas = null;
        
        if (page != null && size != null){
            Pageable pageable = PageRequest.of(page, size, sortByName);
            pizzas = pizzaService.findAll(pageable).getContent();
        } else{
            pizzas = pizzaService.findAll(sortByName);
        }

        return CollectionModel.of(pizzas.stream().map(pizzaModelAssembler::toModel).collect(Collectors.toList()),
        linkTo(methodOn(PizzaController.class).getPizzas(page, size)).withSelfRel());
    }

    @GetMapping(value = "/{id}")
    public EntityModel<Pizza> findById(@PathVariable(name = "id") long id) {

        return pizzaModelAssembler.toModel(pizzaService.findById(id));

    }
}
