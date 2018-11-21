package repository;

import model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeRepository {
	
	ArrayList<Recipe> recipeArray =  new ArrayList<>();

	public List<Recipe> query(String recipeName) {
		List<Recipe> mockRecipes = new ArrayList<>();
		Recipe brandyWithCherry = new Recipe(recipeName);
		mockRecipes.add(brandyWithCherry);
		return mockRecipes;
	}

	/**
	public Recipe getRecipe(String q) {
		
		//�ӽ� ����� start
		Recipe recipe1 = new Recipe("Test");
		Recipe recipe2 = new Recipe("Recipe");
		Recipe returnRecipe = null;
		
		ArrayList<Recipe> recipeArray =  new ArrayList<>();
		recipeArray.add(recipe1);
		recipeArray.add(recipe2);
		//�ӽ� ����� end
		
		for(int i = 0 ; i < recipeArray.size() ; i++) {
			if(q.equals(recipeArray.get(i).recipeName)) {
				returnRecipe = recipeArray.get(i);
			}
		}
		
		return returnRecipe;
	}
	**/
	
}
