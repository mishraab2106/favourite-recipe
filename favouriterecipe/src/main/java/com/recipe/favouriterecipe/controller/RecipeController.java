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



	
@GetMapping("/allrecipe")
List<Recipe> allrecipe(){
	return service.allrecipe();
	
}
@RequestMapping(value = "/addrecipe", method = RequestMethod.POST)

public String addNewRecipe(@Validated @RequestBody Recipe recipe){
	return service.addNewRecipe(recipe);		
}

@PutMapping("/updaterecipe")
public ResponseEntity<Recipe> updateRecipe(@RequestParam long id,@RequestBody Recipe recipe) {
	Recipe updaterecipe=service.getById(id);
	
	updaterecipe.setName(recipe.getName());
	updaterecipe.setIngredients(recipe.getIngredients());
	updaterecipe.setInstructions(recipe.getInstructions());
	updaterecipe.setVegeterian(recipe.getVegeterian());
	updaterecipe.setServings(recipe.getServings());
	 service.addNewRecipe(updaterecipe);
	return ResponseEntity.ok(updaterecipe);
	
}

@DeleteMapping("/deleterecipe")
public String deleterecipe(@RequestParam long id,@RequestBody Recipe recipe) {
	
	service.deleterecipe(id);
	return "Deleted recipe with id " +id;	
}


@GetMapping(value = "/filterrecipe")
public List<Recipe> findfilteredreceipe(@RequestParam(value="ingredientscondition",defaultValue="include") String ingredientscondition,@RequestParam(value="veg",defaultValue="") String veg,@RequestParam(value="servings",defaultValue="") Long servings,
		@RequestParam(value="ingredients",defaultValue="") String ingredients,@RequestParam(value="instructions",defaultValue="") String instructions){
	
	System.out.println("servings "+servings);
	System.out.println("instructions "+instructions);
	System.out.println("veg "+veg);
//	System.out.println("ingredients "+ingredients);
	if(ingredients.equals("")&&instructions.equals("")&&servings==null) {
			return service.findVegeterian(veg);
	}
//	else if(instructions.equals("")&&servings==null&&veg.equals("")) {
//		System.out.println("ingredients "+ingredients);
//		return service.findPotatoesAndServings(ingredients,servings);
//	} else {
	return service.findFilterRecipe(ingredientscondition,ingredients, servings, instructions, veg);

	}
		
					


@GetMapping(value = "/recipewithingandservings")
public List<Recipe> findPotatoesAndServings(@RequestParam("ingredients") String ingredients,@RequestParam("servings") int servings){
		
	return service.findPotatoesAndServings(ingredients,servings);
		
}

@GetMapping(value = "/recipewithoutingandins")
public List<Recipe> findOvenWithoutSalmon(@RequestParam("ingredients") String ingredients,@RequestParam("instructions") String instructions){
		
	return service.findOvenWithoutSalmon(ingredients,instructions);
		
}


}
