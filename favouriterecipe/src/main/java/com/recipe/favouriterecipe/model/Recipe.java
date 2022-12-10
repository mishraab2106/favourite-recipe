package com.recipe.favouriterecipe.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Component
@Entity
@Table(name="Recipe")
public class Recipe {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id;
	@Column(name="name")
	@NotEmpty
	@JsonProperty("name")
	private String name;
	@Column(name="Ingredients")
	@NotEmpty
	@JsonProperty("ingredients")
	private String[] ingredients;
	@Column(name="Instructions")
	@NotEmpty
	@JsonProperty("instructions")
	 private String[] instructions;
	@Column(name="Servings")
	@NotNull
	@JsonProperty("servings")
	 private int servings;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getIngredients() {
		return ingredients;
	}
	public void setIngredients(String[] ingredients) {
		this.ingredients = ingredients;
	}
	public String[] getInstructions() {
		return instructions;
	}
	public void setInstructions(String[] instructions) {
		this.instructions = instructions;
	}
	public int getServings() {
		return servings;
	}
	public void setServings(int servings) {
		this.servings = servings;
	}
	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", ingredients=" + Arrays.toString(ingredients)
				+ ", instructions=" + Arrays.toString(instructions) + ", servings=" + servings + "]";
	}

}
