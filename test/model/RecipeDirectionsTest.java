package model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author kbshin on 2018. 11. 24.
 */
public class RecipeDirectionsTest {
    private String ingredients =
            "cherry: 5(ea),\tbrandy: 1000(ml)\tsugar: 1(kg)";
    private RecipeDirections recipeDirections;

    public RecipeDirectionsTest(){
        recipeDirections = RecipeDirections.getMockDirections();
    }

    @Test
    public void testGetIngredients(){
        assertEquals(ingredients, recipeDirections.getIngredientsString());
    }
}