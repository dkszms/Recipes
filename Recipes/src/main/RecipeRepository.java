package main;

import java.util.ArrayList;

public class RecipeRepository {
	
	ArrayList<Recipe> recipeArray =  new ArrayList<>();

	public Recipe getRecipe(String q) {
		
		//임시 저장소 start
		Recipe recipe1 = new Recipe("Test");
		Recipe recipe2 = new Recipe("Recipe");
		Recipe returnRecipe = null;
		
		ArrayList<Recipe> recipeArray =  new ArrayList<>();
		recipeArray.add(recipe1);
		recipeArray.add(recipe2);
		//임시 저장소 end
		
		for(int i = 0 ; i < recipeArray.size() ; i++) {
			if(q.equals(recipeArray.get(i).recipeName)) {
				returnRecipe = recipeArray.get(i);
			}
		}
		
		return returnRecipe;
	}
	
	
}
