package com.schairamaniega.pizzaproject;

import com.jayway.jsonpath.internal.function.numeric.Sum;
import com.schairamaniega.pizzaproject.entities.Comment;
import com.schairamaniega.pizzaproject.entities.Ingredient;
import com.schairamaniega.pizzaproject.entities.Pizza;
import com.schairamaniega.pizzaproject.services.CommentService;
import com.schairamaniega.pizzaproject.services.IngredientService;
import com.schairamaniega.pizzaproject.services.PizzaService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PizzaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(PizzaService pizzaService, IngredientService ingredientService){

		return args -> {

			ingredientService.save(Ingredient.builder().name("QUESO").price(1.0D).build());
			ingredientService.save(Ingredient.builder().name("SALSA DE TOMATE").price(0.7).build());
			ingredientService.save(Ingredient.builder().name("OREGANO").price(0.5).build());
			ingredientService.save(Ingredient.builder().name("JAMON").price(1.8).build());

			List<Ingredient> test = new ArrayList<Ingredient>();

			test.add(ingredientService.findById(1L));
			test.add(ingredientService.findById(2L));
			test.add(ingredientService.findById(3L));

			double total = test.stream().mapToDouble(d -> d.getPrice().doubleValue()).sum();
			total += total * 0.2F;

			pizzaService.save(Pizza.builder().name("Margarita").img("pizza.jpeg").price(total).ingredients(test).build());

		};
	}

}
