package main;

public class Main {
	public static void main(String[] args) {
		String q = "Test";
		String recipeList = "";
		
		RecipeRepository rr = new RecipeRepository();
		
		Recipe recipe = rr.getRecipe(q);
		
		recipe.setQuantity(3);
					
		for(int i = 0 ; i < recipe.recipeMap.size() ; i++) {
			recipeList += "\n"+i+" : "+recipe.recipeMap.get((1+i));
		}
		
		System.out.println(recipe.getRecipeName()+ " - " +recipe.getQuantity()+" : "+ recipeList);
		
	}
}
