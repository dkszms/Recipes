package model;

import java.util.HashMap;

public class Recipe {

	private String recipeName;
	private double quantity;
	private String simpleDesc;
	private String image;
	private RecipeDirections directions;
	private String ingredients;

	public Recipe(String q) {
		recipeName = q;
		quantity = 10.0;
		simpleDesc = "cherry + brandy + sugar";
		image = "This is an image";
		directions = RecipeDirections.getMockDirections();
		ingredients = "cherry: 5 ea\nbrandy: 10 bottles\nsugar 1kg";
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getSimpleDesc() {
		return simpleDesc;
	}

	public void setSimpleDesc(String simpleDesc) {
		this.simpleDesc = simpleDesc;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public RecipeDirections getDirections() {
		return this.directions;
	}

	public void setDirections(RecipeDirections directions) {
		this.directions = directions;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
}
