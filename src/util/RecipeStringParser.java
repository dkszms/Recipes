package util;

import com.sun.rowset.internal.Row;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TODO: iterating recipeStringParser
 * @author kbshin on 2018. 11. 28.
 */
public abstract class RecipeStringParser {
    public static Recipe parseRecipe(List<String> recipeString){
        Recipe recipe = new Recipe();

        String name = recipeString.get(0);
        double quantity = Double.parseDouble(recipeString.get(1));
        String simpleDesc = recipeString.get(2);
        List<String> directions = recipeString.subList(3,recipeString.size()-1);
        List<RecipeDirection> recipeDirections = parseDirections(directions, quantity);

        recipe.setRecipeName(name);
        recipe.setQuantity(quantity);
        recipe.setSimpleDesc(simpleDesc);
        recipe.setDirections(recipeDirections);

        return recipe;
    }

    private static List<RecipeDirection> parseDirections(List<String> directions, double originalQuantity){
        List<RecipeDirection> recipeDirections= new ArrayList<>();
        for(String str : directions) {
            RecipeDirection recipeDirection = parseDirection(str, originalQuantity);
            recipeDirections.add(recipeDirection);
        }

        return recipeDirections;
    }

    private static RecipeDirection parseDirection(String str, double originalQuantity) {
        //정규식 구현

        List<DirectionElement> directionElements = getDirectionElements(str);
        RecipeDirection recipedirection= new RecipeDirection(directionElements, originalQuantity);

        return recipedirection;
    }

    private static List<DirectionElement> getDirectionElements(String str){
        //스트링을 받아서 정규식을 이용해 나눈다.
        Pattern p = Pattern.compile("\\[.*?\\]");
        Matcher m = p.matcher(str);
//	      List<DirectionElement> directionElements;
        List<DirectionElement> directionElements = new ArrayList<>();
        int before = 0 ;
        while(m.find()) {
            System.out.println(m.start() + " @@@ " + m.group() + " ### " + m.end() );
            if(before < m.start()) {
                directionElements.add(new Description(str.substring(before, m.start())));
            }
            directionElements.add(getIngredient(m.group()));// 메소드 통해서 배율을 곱해서 처리한다.
            before = m.end();
        }
        if(before < str.length()) {
            directionElements.add(new Description(str.substring(before)));
        }
        return directionElements;
    }

    private static Ingredient getIngredient(String ingredientStr) {
        String[] ings  = ingredientStr.substring(1, ingredientStr.length()-1).split(",");
        String name = ings[0];
        double amount = Double.parseDouble(ings[1]);
        String unit = ings[2];

        return new Ingredient(name, amount, unit);
    }
}
