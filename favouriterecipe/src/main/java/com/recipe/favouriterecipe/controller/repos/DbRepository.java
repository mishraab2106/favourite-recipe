package com.recipe.favouriterecipe.controller.repos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.recipe.favouriterecipe.model.Recipe;

@Repository
public interface DbRepository extends JpaRepository<Recipe,Long>{
	
	@Query(value = "SELECT * FROM recipe ",nativeQuery = true)
	List<Recipe> findallrecipe();
	
}