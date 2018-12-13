package viewer;

import model.Recipe;
//상속구조
public class CLRecipeViewer extends RecipeViewer {//command line용으로 작성.
    public CLRecipeViewer(){
        System.out.println("This is a command line recipe viewer");
    }
    public void show() {
        Recipe recipe = super.getRecipe();

        System.out.println(recipe.toString());
    }

}
