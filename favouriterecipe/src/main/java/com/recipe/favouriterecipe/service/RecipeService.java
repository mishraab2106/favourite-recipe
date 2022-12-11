package com.recipe.favouriterecipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.recipe.favouriterecipe.model.Recipe;
import com.recipe.favouriterecipe.repos.DbRepository;

@Service
public class RecipeService {

@Autowired
private DbRepository repo;
@Autowired
private Recipe recipe;

public List<Recipe>allrecipe() {
	return repo.findAll();
//	return repo.findallrecipe();
//	return repo.findinstructionsrecipe();
} 

public String addNewRecipe(Recipe recipe) {
	 repo.save(recipe);
	 return "Saved Data successfully";
}

public List<Recipe>findPotatoesAndServings(String ingredients,int servings) {
	return repo.findPotatoesAndservings(ingredients,servings);

} 

public List<Recipe>findVegeterian(String veg) {
	return repo.findByvegeterian(veg);

} 
public List<Recipe>findOvenWithoutSalmon(String ingredients,String instructions) {
	return repo.findOvenWithoutSalmon(ingredients,instructions);

}

public void deleterecipe(long id) {
	repo.deleteById(id);
	
}

public Recipe getById(long id) {
	// TODO Auto-generated method stub
	return repo.getById(id);
}


public List<Recipe> findFilterRecipe(String ingredients, int servings, String instructions, String veg) {
	// TODO Auto-generated method stub
//	return repo.findFilterRecipe(ingredients, servings, instructions, veg);

		return repo.filterRecipeinclude(ingredients,servings,instructions,veg);

		
	//	return repo.filterRecipeexclude(ingredients, servings, instructions, veg);
	}
	

}
