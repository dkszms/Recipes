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

        System.out.println(buildDescriptionString(recipe));
    }
    private String buildDescriptionString(Recipe recipe) {
    	String recipeName = recipe.getRecipeName();
    	StringBuilder stringBuilder = new StringBuilder();
    	stringBuilder.append("This recipe is ").append(recipeName).append("\n");
    	stringBuilder.append("served quantity: ").append(recipe.getQuantity()).append("\n");
    	stringBuilder.append(recipe.getSimpleDesc()).append("\n");
        stringBuilder.append("Image:\n").append(recipe.getImage()).append("\n");
        stringBuilder.append("Ingredients: ").append(recipe.getIngredients());

        return stringBuilder.toString();
    }
}
