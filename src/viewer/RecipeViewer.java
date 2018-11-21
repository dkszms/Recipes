package viewer;

import model.Recipe;

import java.util.List;
//TODO: 상속 구조 개선
public class RecipeViewer {

    public Recipe getRecipe() {
        return recipe;
    }

    private Recipe recipe;

    public List<Recipe> getRecipes() {
        return recipes;
    }

    private List<Recipe> recipes;

    public RecipeViewer(){
        System.out.println("This is recipe viewer");
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public void show() {
    }

    public void setRecipeList(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}
