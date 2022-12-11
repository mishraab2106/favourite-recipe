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
	@Query(value = "select * from recipe where vegeterian='yes'", nativeQuery=true)
	List<Recipe> findByvegeterian();
	@Query(value = "select * from recipe where ingredients LIKE '%potatoes%' AND servings='4'",nativeQuery = true)
	List<Recipe> findPotatoesAndservings();
	
}