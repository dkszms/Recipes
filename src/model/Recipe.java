package model;

import java.util.HashMap;

public class Recipe {
	
	String recipeName = "";

	public HashMap<Integer, String> getRecipeMap() {
		return recipeMap;
	}

	HashMap<Integer, String> recipeMap = new HashMap<>(); //hashmap은 오더가 보존되지 않음. 걍 리스트를 쓰는 게 좋을 수 있음.

	
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
