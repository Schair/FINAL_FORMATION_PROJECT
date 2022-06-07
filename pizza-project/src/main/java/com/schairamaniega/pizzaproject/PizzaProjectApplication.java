package com.schairamaniega.pizzaproject;

import com.jayway.jsonpath.internal.function.numeric.Sum;
import com.schairamaniega.pizzaproject.entities.Comment;
import com.schairamaniega.pizzaproject.entities.Ingredient;
import com.schairamaniega.pizzaproject.entities.Pizza;
import com.schairamaniega.pizzaproject.entities.User;
import com.schairamaniega.pizzaproject.services.CommentService;
import com.schairamaniega.pizzaproject.services.IngredientService;
import com.schairamaniega.pizzaproject.services.PizzaService;
import com.schairamaniega.pizzaproject.services.UserService;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	public CommandLineRunner demoData(PizzaService pizzaService, IngredientService ingredientService,
		UserService userService, CommentService commentService){

		return args -> {

			// TYPES: [0- GENERAL INGREDIENT, 1- DOUGH, 2- CHEESE, 3- SAUCE]

			ingredientService.save(Ingredient.builder().name("MASA NORMAL").price(1.0).type(1).build());
			ingredientService.save(Ingredient.builder().name("MASA FINA").price(1.25).type(1).build());
			ingredientService.save(Ingredient.builder().name("QUESO").type(2).price(1.0D).build());
			ingredientService.save(Ingredient.builder().name("QUESO AZUL").type(2).price(1.6).build());
			ingredientService.save(Ingredient.builder().name("QUESO MOZZARELLA").type(2).price(1.8).build());
			ingredientService.save(Ingredient.builder().name("QUESO PARMESANO").type(2).price(1.75).build());
			ingredientService.save(Ingredient.builder().name("JAMON").price(2.1).build());
			ingredientService.save(Ingredient.builder().name("JAMON DE YORK").price(1.8).build());
			ingredientService.save(Ingredient.builder().name("PEPPERONNI").price(2.0).build());
			ingredientService.save(Ingredient.builder().name("POLLO").price(1.8).build());
			ingredientService.save(Ingredient.builder().name("CARNE PICADA").price(1.9).build());
			ingredientService.save(Ingredient.builder().name("SALSA DE TOMATE").type(3).price(0.7).build());
			ingredientService.save(Ingredient.builder().name("SALSA DE TOMATE ESPECIAL").price(1.0).type(3).build());
			ingredientService.save(Ingredient.builder().name("SALSA BARBACOA").type(3).price(1.8).build());
			ingredientService.save(Ingredient.builder().name("SALSA MOSTAZA").type(3).price(1.8).build());
			ingredientService.save(Ingredient.builder().name("OREGANO").price(0.5).build());
			ingredientService.save(Ingredient.builder().name("ACEITUNAS").price(1.0).build());
			ingredientService.save(Ingredient.builder().name("CHAMPIÑONES").price(1.35).build());
			ingredientService.save(Ingredient.builder().name("PIÑA").price(0.9).build());
			ingredientService.save(Ingredient.builder().name("BACON").price(1.2).build());



			// USERS

			userService.save(User.builder().name("User").email("example@domain.com").password("1234").surname("Name").build());
			userService.save(User.builder().name("Peter").email("pizzalover27@gmail.com").password("567890").surname("Parker").build());
			userService.save(User.builder().name("Pete").email("petezetas@gmail.com").password("abcdefg").surname("Zass").build());

			// List<Ingredient> ingredients = new ArrayList<Ingredient>();

			// PIZZA MARGARITA
			this.createPizza("Margarita", new Long[]{1L, 3L, 12L, 16L, 8L}, ingredientService, pizzaService);

			// PIZZA PROSCIUTTO
			this.createPizza("Prosciutto", new Long[]{1L, 3L, 12L, 16L, 7L}, ingredientService, pizzaService);

			// PIZZA YORKESO
			this.createPizza("Yorkeso", new Long[]{1L, 5L, 12L, 16L, 8L}, ingredientService, pizzaService);

			// PIZZA CUATRO-QUESOS
			this.createPizza("Cuatro Quesos", new Long[]{1L, 3L, 4L, 5L, 6L, 12L, 16L}, ingredientService, pizzaService);

			// PIZZA HAWAIANA
			this.createPizza("Hawaiana", new Long[]{1L, 5L, 12L, 14L, 16L, 19L, 20L}, ingredientService, pizzaService);

			// PIZZA NATA
			this.createPizza("Nata", new Long[]{1L, 5L, 6L, 8L, 13L, 15L, 16L}, ingredientService, pizzaService);

			// PIZZA PEPPERONNISIMA
			this.createPizza("Pepperonnisima", new Long[]{2L, 3L, 9L, 12L, 16L}, ingredientService, pizzaService);

			// PIZZA BBQ-MIX
			this.createPizza("BBQ-Mix", new Long[]{1L, 3L, 10L, 11L, 12L, 16L, 14L}, ingredientService, pizzaService);

			for (Pizza pizza : pizzaService.findAll()) {
				byte[] array = new byte[10]; // length is bounded by 7
				new Random().nextBytes(array);
				String generatedString = new String(array, Charset.forName("UTF-8"));

				commentService.save(Comment.builder().body(generatedString).user(userService.findNameById((long)Math.floor(Math.random() * 3 + 1))).score(Math.random() * 10).pizza(pizza).build());
			}
		};
	}

	private double getPrice(List<Ingredient> list){
		double total = list.stream().mapToDouble(d -> d.getPrice().doubleValue()).sum();
		total += total * 0.2F;
		return total;
	}

	private void createPizza(String name, Long[] ingredientsArray, IngredientService ingredientService, PizzaService pizzaService){
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		double price;

		ingredients.clear();

		for (Long ingredient : ingredientsArray) {
			ingredients.add(ingredientService.findById(ingredient));
		}

		price = getPrice(ingredients);
		
		pizzaService.save(Pizza.builder().name(name).img("pizza.jpeg").price(price).ingredients(ingredients).build());
	}

}
