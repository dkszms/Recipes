package main;

import java.util.HashMap;

public class Recipe {
	
	String recipeName = "";
	HashMap<Integer, String> recipeMap = new HashMap<>();

	
	public Recipe(String q) {
		recipeName = q;
		
		if("Test".equals(q)) {
			recipeMap.put(1, "ü�� �ľ�");
			recipeMap.put(2, "�� �ο�");
			recipeMap.put(3, "����");
			recipeMap.put(4, "����");
		}else {
			recipeMap.put(1, "�� �ο�");
			recipeMap.put(2, "��� �־�");
			recipeMap.put(3, "����");
			recipeMap.put(4, "�Ծ�");
	
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
