package com.schairamaniega.pizzaproject.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.schairamaniega.pizzaproject.entities.Pizza;
import com.schairamaniega.pizzaproject.hateoas.assemblers.PizzaModelAssembler;
import com.schairamaniega.pizzaproject.services.PizzaService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
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

    @PostMapping
	// public ResponseEntity<Map<String, Object>> save(@Valid @RequestBody Pizza pizza, BindingResult bindingResult){
    public ResponseEntity<Map<String, Object>> save(@ModelAttribute Pizza pizza, BindingResult bindingResult){

		ResponseEntity<Map<String, Object>> responseEntity = null;
		Map<String, Object> responseAsMap = new HashMap<>();

		if(bindingResult.hasErrors()){

			List<String> errorMessages = new ArrayList<String>();

			for (ObjectError error : bindingResult.getAllErrors()) {
				errorMessages.add(error.getDefaultMessage());
			}

			responseAsMap.put("ERRORES", errorMessages);

			responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.BAD_REQUEST);

			return responseEntity;

			// return new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.BAD_REQUEST);
		}

		try {

			Pizza pizzaDB = pizzaService.save(pizza);

			if (pizzaDB != null) {
				
				responseAsMap.put("SUCCESS", "Pizza" + pizzaDB.getName() + " has been succesfully posted!");
				responseAsMap.put("PIZZA", pizzaDB);

				responseEntity = new ResponseEntity<>(responseAsMap, HttpStatus.CREATED);

			} else {
				
				responseAsMap.put("ERROR", "Error posting the product.");

				responseEntity = new ResponseEntity<>(responseAsMap, HttpStatus.BAD_GATEWAY);
				
			}

		} catch (DataAccessException e) {
			
			responseAsMap.put("ERROR", "Error caused by " + e.getMostSpecificCause());

			responseEntity = new ResponseEntity<>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}

		return responseEntity;
	}
}
