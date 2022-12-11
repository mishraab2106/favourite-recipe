package com.recipe.favouriterecipe.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.recipe.favouriterecipe.controller.repos.DbRepository;
import com.recipe.favouriterecipe.model.Recipe;

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

public List<Recipe>findPotatoesAndServings() {
	return repo.findPotatoesAndservings();

} 

public List<Recipe>findVegeterian() {
	return repo.findByvegeterian();

} 
}
