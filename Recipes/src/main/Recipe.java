package main;

import java.util.HashMap;

public class Recipe {
	
	String recipeName = "";
	HashMap<Integer, String> recipeMap = new HashMap<>();

	
	public Recipe(String q) {
		recipeName = q;
		
		if("Test".equals(q)) {
			recipeMap.put(1, "체리 씻어");
			recipeMap.put(2, "술 부워");
			recipeMap.put(3, "절여");
			recipeMap.put(4, "마셔");
		}else {
			recipeMap.put(1, "물 부워");
			recipeMap.put(2, "고기 넣어");
			recipeMap.put(3, "끓여");
			recipeMap.put(4, "먹어");
	
		}
	}
	int quantity = 1;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getRecipeName() {
		return recipeName;
	}
	
	
	
	
}
