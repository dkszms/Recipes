package model;

import java.util.List;

/**
 *
 * @author kbshin on 2018. 11. 24.
 */
public class RecipeDirections {
    private List<RecipeDirection> directions;

    public static RecipeDirections getMockDirections() {
        return new RecipeDirections();
    }

    public String getIngredientsString() {
        return "cherry: 5(ea),\tbrandy: 1000(ml)\tsugar: 1(kg)";
    }
}
