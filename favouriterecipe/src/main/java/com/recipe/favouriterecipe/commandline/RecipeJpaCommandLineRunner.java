package com.recipe.favouriterecipe.commandline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.recipe.favouriterecipe.model.Recipe;
import com.recipe.favouriterecipe.repos.DbRepository;

//@Component
public class RecipeJpaCommandLineRunner implements CommandLineRunner {

	
	@Autowired
	private DbRepository repo;
	@Autowired
	private Recipe recipe;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		recipe.setId(1);
//		recipe.setIngredients({"boiled water", "salmon","oil"});
		recipe.setInstructions(args);
		recipe.setName(null);
		recipe.setServings(null);
		recipe.setVegeterian("yes");
		
		
//		repo.save(null)
		
	//	repo.insertrecipe(2,"[boiled water, salmon,oil]","[Ignite oven,Boil water, Pour boiling hot water into a mug,Mix and let the salmon for 3-5 minutes, Add oil and mix again]","Salmon dish",4,"no");
		
	}

}
