package sample;

import model.Recipe;
import org.junit.Test;
import repository.MockRecipeRepository;
import repository.RecipeRepository;
import viewer.CLRecipeViewer;
import viewer.RecipeViewer;

import java.util.List;

import static org.junit.Assert.*;

/**
 *
 * @author kbshin on 2018. 11. 24.
 */
public class MainTest {
    @Test
    public void testMain(){
        RecipeViewer rv = new CLRecipeViewer();
        String recipeName = "brandyWithCherry";
        RecipeRepository rr = new MockRecipeRepository();

        List<Recipe> recipes = rr.query(recipeName);
        //검색 결과 보여주기
        rv.setRecipeList(recipes);
        //검색 결과 중 하나 선택하기
        rv.setRecipe(recipes.get(0));
        //해당 recipe를 보여주기
        rv.show();
    }
}