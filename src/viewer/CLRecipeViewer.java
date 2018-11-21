package viewer;

import model.Recipe;

import java.util.List;
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
        return "This recipe is " + recipe.getRecipeName();
    }
}
