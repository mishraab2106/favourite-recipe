package com.recipe.favouriterecipe.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

@GetMapping(value = "/allrecipe")
public List<Recipe> findvegeterian(@RequestParam String veg ){
		
	return service.findVegeterian(veg);
		
}

@GetMapping(value = "/recipe")
public List<Recipe> findPotatoesAndServings(@RequestParam("ingredients") String ingredients,@RequestParam("servings") int servings){
		
	return service.findPotatoesAndServings(ingredients,servings);
		
}

@GetMapping(value = "/ingredients/{ingredients}/instructions/{instructions}")
public List<Recipe> findOvenWithoutSalmon(@PathVariable String ingredients,@PathVariable String instructions){
		
	return service.findOvenWithoutSalmon(ingredients,instructions);
		
}


}
