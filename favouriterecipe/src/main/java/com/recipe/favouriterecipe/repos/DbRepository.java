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
	List<Recipe> findPotatoesAndservings(@Param("ingredients")String ingredients,@Param("servings") Long servings);
	@Query(value="select * from recipe where ingredients NOT LIKE CONCAT ('%',:ingredients,'%') AND instructions LIKE CONCAT ('%',:instructions,'%')",nativeQuery = true)
	List<Recipe> findOvenWithoutSalmon(@Param("ingredients")String ingredients,@Param("instructions")String instructions);
	@Query(value = "select * from recipe where name LIKE CONCAT('%',:name,'%')",nativeQuery = true)
	List<Recipe> fetchRecipe(@Param("name")String name);
	
	
	@Query(value = "select * from recipe where ingredients iLIKE CONCAT ('%',:ingredients,'%') AND instructions iLIKE CONCAT ('%',:instructions,'%') AND servings= :servings AND vegeterian= :vegeterian",nativeQuery = true)
	List<Recipe> filterRecipeinclude(@Param("ingredients")String ingredients,@Param("servings")Long servings,@Param("instructions")String instructions,@Param("vegeterian")String vegeterian);
	
	@Query(value = "select * from recipe where ingredients  NOT iLIKE CONCAT ('%',:ingredients,'%') AND instructions  iLIKE CONCAT ('%',:instructions,'%') AND servings= :servings AND vegeterian= :vegeterian",nativeQuery = true)
	List<Recipe> filterRecipeexclude(@Param("ingredients")String ingredients,@Param("servings")Long servings,@Param("instructions")String instructions,@Param("vegeterian")String vegeterian);
    
	@Query(value = "select * from recipe where servings=:servings",nativeQuery = true)
	List<Recipe> findByServings(@Param("servings")Long servings);
	
	@Query(value = "select * from recipe where ingredients iLIKE CONCAT ('%',:ingredients,'%')",nativeQuery = true)
	List<Recipe> findByingredients(@Param("ingredients")String ingredients);
	
	@Query(value = "select * from recipe where ingredients NOT iLIKE CONCAT ('%',:ingredients,'%')",nativeQuery = true)
	List<Recipe> findByExcludedIngredients(@Param("ingredients")String ingredients);
	
	@Query(value = "select * from recipe where instructions iLIKE CONCAT ('%',:instructions,'%')",nativeQuery = true)
	List<Recipe> findByInstructions(@Param("instructions")String instructions);

}