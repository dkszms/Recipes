package util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author kbshin on 2018. 11. 28.
 */
public class IteratingExcelRecipeReaderTest {
    private IteratingExcelRecipeReader reader;

    public IteratingExcelRecipeReaderTest () throws IOException, InvalidFormatException {
         reader = new IteratingExcelRecipeReader(new File("resource/recipe_test.xlsx"));
    }

    @Test
    public void testGetDirectionElements(){
        String str = "[씨를 제거한 체리, 7, cup]에 [설탕, 450, g]과 [브랜디, 60, ml]를 섞어서 하룻밤 재어놓는다.";
        String[] expectedResult = {"씨를 제거한 체리 7.00 cup", "에 ", "설탕 450.00 g", "과 ", "브랜디 60.00 ml", "를 섞어서 하룻밤 재어놓는다. "};
        List<DirectionElement> testElements = reader.getDirectionElements(str);
        for (int i =0, endIndex = testElements.size();i<endIndex;i++){
            assertEquals(expectedResult[i], testElements.get(i).toString());
        }
    }

    @Test
    public void parseRecipe() {
        Recipe recipe1 = reader.iterator().next();
        //품질 테스트
        assertEquals("브랜디에 절인 체리", recipe1.getRecipeName());
        Assert.assertTrue(Math.abs(1 - recipe1.getQuantity()) < 0.01);
        assertEquals("브랜디에 절인 체리입니다.", recipe1.getSimpleDesc());
        List<RecipeDirection> recipeDirections = recipe1.getDirections();
        RecipeDirection rd = recipeDirections.get(0);
        assertEquals("씨를 제거한 체리 7.00 cup에 설탕 450.00 g과 브랜디 60.00 ml를 섞어서 하룻밤 재어놓는다.", recipeDirections.get(0).getDescriptionString());
    }

    @Test
    public void iterator() {
        Iterator<Recipe> itr = reader.iterator();
        int cnt= 0;
        while (itr.hasNext()){
            cnt++;
            itr.next();
        }
        assertEquals(5, cnt);
    }
}