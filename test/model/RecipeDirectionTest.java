package model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 *
 * @author kbshin on 2018. 11. 24.
 */
public class RecipeDirectionTest {
    private double defaultQuant = 2.0;

    private RecipeDirection recipeDirection;

    public RecipeDirectionTest() {
        List<DirectionElement> directionElements = new ArrayList<>();
        directionElements.add(new Ingredient("씨를 제거한 체리", 7.0, "cup"));
        directionElements.add(new Description("에"));
        directionElements.add(new Ingredient("설탕",450,"g"));
        directionElements.add(new Description("과"));
        directionElements.add(new Ingredient("브랜디", 60, "ml"));
        directionElements.add(new Description("를 섞어서 하룻밤 재어놓는다."));
        recipeDirection = new RecipeDirection(directionElements, 2.0);
    }

    @Test
    public void testGetDescString(){
        String expected = "씨를 제거한 체리 7.00cup에 설탕 450.00g과 브랜디 60.00ml를 섞어서 하룻밤 재어놓는다.";
        String actual = recipeDirection.getDescriptionString();

        assertTrue("\nexpected:\t" + expected + '\n' + "actual:\t" + actual, expected.equals(actual));
    }
    @Test
    public void testSetQuantity(){
        recipeDirection.setQuantity(2*defaultQuant);
        assertEquals("씨를 제거한 체리 14.00cup에 설탕 900.00g과 브랜디 120.00ml를 섞어서 하룻밤 재어놓는다.", recipeDirection.getDescriptionString());
        recipeDirection.setQuantity(4*defaultQuant);
        assertEquals("씨를 제거한 체리 28.00cup에 설탕 1800.00g과 브랜디 240.00ml를 섞어서 하룻밤 재어놓는다.", recipeDirection.getDescriptionString());
    }
}