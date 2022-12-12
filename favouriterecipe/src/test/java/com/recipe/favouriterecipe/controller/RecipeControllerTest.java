package com.recipe.favouriterecipe.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.recipe.favouriterecipe.model.Recipe;
import com.recipe.favouriterecipe.service.RecipeService;

@ExtendWith(MockitoExtension.class)
public class RecipeControllerTest {
	@InjectMocks
	RecipeController recipecontroller;
	@Mock
	RecipeService service;
	@Test
	String test() {
		RecipeController recipecontroller=new RecipeController();
		Recipe recipe=new Recipe();
		recipe.setId(1);
		String [] ing={"boiled water",
        "salmon"} ;
		recipe.setIngredients(ing);
		String [] ins= {"Ignite oven",
	            "Boil water",
	            "Pour boiling hot water into a mug",
	            "Mix and let the salmon for 3-5 minutes",
	            "Add oil and mix again"};
		recipe.setInstructions(ins);
		recipe.setName("Salmon dish");
		recipe.setServings((long) 3);
		recipe.setVegeterian("yes");		
		System.out.println(recipe);		
		String response=recipecontroller.addNewRecipe(recipe);
		recipecontroller.addNewRecipe(recipe);
	    assertEquals("Saved Data successfully", response);

		return response;
	}

}
