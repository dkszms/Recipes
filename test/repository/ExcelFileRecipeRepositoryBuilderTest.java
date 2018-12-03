package repository;

import model.Recipe;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

/**
 *
 * @author kbshin on 2018. 12. 3.
 */
public class ExcelFileRecipeRepositoryBuilderTest {
    private File excelRecipeDataFile = new File("resource/recipe_test.xlsx");

    @Test
    public void testGetInstance() {
        try {
            FileRecipeRepository frr = ExcelFileRecipeRepositoryBuilder.getInstance(this.excelRecipeDataFile);
            List<Recipe> recipeList = frr.getAll();
            assertEquals(5, recipeList.size());
            for (Recipe recipe: recipeList){
                assertEquals("", recipe.toString());
            }

            //Recipe 클래스의 구현에 대한 테스트가 미비. equal?
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
}