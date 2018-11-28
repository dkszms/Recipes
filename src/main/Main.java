package main;

import model.Recipe;
import repository.RecipeRepository;
import viewer.CLRecipeViewer;
import viewer.RecipeViewer;

import java.util.List;

public class Main {
	public static void main(String[] args) {
        RecipeViewer rv = new CLRecipeViewer();
	    String q = "Brandy with Cherry";

		RecipeRepository rr = new RecipeRepository();

		List<Recipe> recipes = rr.query(q);//search, query, 기타 등등
		//검색 결과 보여주기: 초기화면
		rv.setRecipeList(recipes);
		//검색 결과 중 하나 선택하기
		rv.setRecipe(recipes.get(0));
		//해당 recipe 해당 사항을 보여주기
		rv.show();//refresh 동작.

		//필수적이지 않은 스텝은 제거.
        /*
        recipe.setCoefficient(3);
        String recipeList = "";
		for(int i = 0 ; i < recipe.recipeMap.size() ; i++) {
			recipeList += "\n"+i+" : "+recipe.recipeMap.get((1+i));
		}
		
		System.out.println(recipe.getRecipeName()+ " - " +recipe.getQuantity()+" : "+ recipeList);
		*/
	}
}
