package com.recipe.favouriterecipe.repos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.recipe.favouriterecipe.model.Recipe;

@Repository
public interface DbRepository extends JpaRepository<Recipe,Long>{
	
	
	@Query(value = "SELECT * FROM recipe ",nativeQuery = true)
	List<Recipe> findallrecipe();
	@Query(value = "SELECT * FROM recipe where id=?1 ",nativeQuery = true)
	Recipe getById(Long id);
	@Query(value = "select * from recipe  where vegeterian= ?1", nativeQuery=true)
	List<Recipe> findByvegeterian(String veg);
//	@Query(value = "select * from recipe where ingredients LIKE '%ingredients%' AND servings='4'",nativeQuery = true)
	@Query(value = "select * from recipe where ingredients LIKE CONCAT ('%',:ingredients,'%') AND servings= :servings", nativeQuery = true)
	List<Recipe> findPotatoesAndservings(@Param("ingredients")String ingredients,@Param("servings") int servings);
	@Query(value="select * from recipe where ingredients NOT LIKE CONCAT ('%',:ingredients,'%') AND instructions LIKE CONCAT ('%',:instructions,'%')",nativeQuery = true)
	List<Recipe> findOvenWithoutSalmon(@Param("ingredients")String ingredients,@Param("instructions")String instructions);
	
	
}