package com.recipe.favouriterecipe.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.recipe.favouriterecipe.controller.service.RecipeService;
import com.recipe.favouriterecipe.model.Recipe;

@RestController

public class RecipeController {
@Autowired
private RecipeService service;

	
@GetMapping("/all")
List<Recipe> allrecipe(){
	return service.allrecipe();
	
}
//@GetMapping(value = "/new",consumes = {"application/json"})
@RequestMapping(value = "/new", method = RequestMethod.POST)

public String addNewRecipe(@Validated @RequestBody Recipe recipe){
	
	
	System.out.println("Servinsg" +recipe.getServings());
	return service.addNewRecipe(recipe);
		
}

@GetMapping(value = "/vegeterian")
public List<Recipe> findvegeterian(){
		
	return service.findVegeterian();
		
}

@GetMapping(value = "/potatoes/servings")
public List<Recipe> findPotatoesAndServings(){
		
	return service.findPotatoesAndServings();
		
}


}
