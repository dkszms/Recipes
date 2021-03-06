package model;

import java.util.List;

public class Recipe {

	private String recipeName;
	private double quantity;
	private String simpleDesc;
	private String image;
	private List<RecipeDirection> directions;
	private String ingredients;

	
	//TODO toString 구현 필요
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder value = new StringBuilder();
		value.append(recipeName + " ") ;
		value.append(quantity + " ");
		value.append(simpleDesc + " ");
		for (RecipeDirection rd : directions) {
			value.append(rd.getDescriptionString());
			
		}
		
		return value.toString();
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

	public List<RecipeDirection> getDirections() {
		return this.directions;
	}

	public void setDirections(List<RecipeDirection> directions) {
		this.directions = directions;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
}
