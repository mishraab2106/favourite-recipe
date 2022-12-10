package com.recipe.favouriterecipe.controller.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipe.favouriterecipe.model.Recipe;

@Repository
public interface DbRepository extends JpaRepository<Recipe,Long>{
	
}