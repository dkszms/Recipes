package viewer;

import java.util.ArrayList;

import model.Recipe;
//상속구조
public class CLRecipeViewer extends RecipeViewer {//command line용으로 작성.
    public CLRecipeViewer(){
        System.out.println("This is a command line recipe viewer");
    }
    public void show() {
        Recipe recipe = super.getRecipe();
        //TODO: generate string from recipe
        System.out.println(buildDescriptionString(recipe));
    }
    private String buildDescriptionString(Recipe recipe) {
    	
    	String recipeName = recipe.getRecipeName();
    	ArrayList<String> recipeList = recipe.getRecipeList();
    	String recipeDesc = ""; 
    	
    	for(int i = 0 ; i<recipeList.size() ; i++) {
    		recipeDesc += "\n" + (i+1) + " : "+recipeList.get(i).toString();
    		
    	}
    	
        return "This recipe is " + recipeName + recipeDesc;
    }
}
