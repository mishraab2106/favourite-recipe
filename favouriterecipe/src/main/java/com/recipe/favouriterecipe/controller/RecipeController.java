package com.recipe.favouriterecipe.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.favouriterecipe.model.Recipe;
import com.recipe.favouriterecipe.repos.DbRepository;
import com.recipe.favouriterecipe.service.RecipeService;

@RestController

public class RecipeController {
@Autowired
private RecipeService service;
@Autowired
private DbRepository repo;


	
@GetMapping("/all")
List<Recipe> allrecipe(){
	return service.allrecipe();
	
}
@RequestMapping(value = "/newrecipe", method = RequestMethod.POST)

public String addNewRecipe(@Validated @RequestBody Recipe recipe){
	return service.addNewRecipe(recipe);		
}

@PutMapping("/updaterecipe")
public ResponseEntity<Recipe> updateRecipe(@RequestParam long id,@RequestBody Recipe recipe) {
	Recipe updaterecipe=repo.getById(id);
	
	updaterecipe.setName(recipe.getName());
	updaterecipe.setIngredients(recipe.getIngredients());
	updaterecipe.setInstructions(recipe.getInstructions());
	updaterecipe.setVegeterian(recipe.getVegeterian());
	updaterecipe.setServings(recipe.getServings());
	 repo.save(updaterecipe);
	return ResponseEntity.ok(updaterecipe);
	
}

@DeleteMapping("/deleterecipe")
public String deleterecipe(@RequestParam long id,@RequestBody Recipe recipe) {
	repo.deleteById(id);
	return "Deleted recipe with id " +id;	
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
