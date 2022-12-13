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
public Object fetchRecipe(String name) {
	return repo.fetchRecipe(name);
}

public List<Recipe>allrecipe() {
	return repo.findAll();
//	return repo.findallrecipe();
//	return repo.findinstructionsrecipe();
} 

public String addNewRecipe(Recipe recipe) {
	 repo.save(recipe);
	 return "Saved Data successfully";
}

public List<Recipe>findPotatoesAndServings(String ingredients,long servings) {
	return repo.findPotatoesAndservings(ingredients,servings);

} 

public List<Recipe>findVegeterian(String veg) {
	return repo.findByvegeterian(veg);

} 
public List<Recipe>findByServings(Long servings) {
	return repo.findByServings(servings);

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


public List<Recipe> findFilterRecipe(String ingredientscondition,String ingredients, Long servings, String instructions, String veg) {
    
	System.out.println("ingredientscondition " +ingredientscondition);
	if (ingredientscondition.equals("exclude")) {
		return repo.filterRecipeexclude(ingredients, servings, instructions, veg);
	}
		
		return repo.filterRecipeinclude(ingredients,servings,instructions,veg);
		
	

		

	}

public List<Recipe> findByingredients(String ingredients,String ingredientscondition) {
	if (ingredientscondition.equals("exclude")) {
		return repo.findByExcludedIngredients(ingredients);
	} else {
		return repo.findByingredients(ingredients);
	}
	
}

public List<Recipe> findByInstructions(String instructions) {
	// TODO Auto-generated method stub
	return repo.findByInstructions(instructions);
}
	

}
