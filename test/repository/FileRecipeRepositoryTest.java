package repository;

import model.Recipe;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import util.IteratingExcelRecipeReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 *
 * @author kbshin on 2018. 12. 1.
 */
public class FileRecipeRepositoryTest {

    public List<Recipe> testFileRecipeRepository() throws IOException, InvalidFormatException {
        File file = new File ("resource/recipe_test.xlsx");

        XSSFWorkbook wb = new XSSFWorkbook(file);

        Sheet sheet = wb.getSheetAt(0);

        List<Recipe> recipeList = new ArrayList<>();
        // POi를 사용해서 1row를 받아온다.
        IteratingExcelRecipeReader iter = new IteratingExcelRecipeReader(file);
        for(Recipe recipe : iter) {
//            System.out.println(recipe);
            recipeList.add(recipe);
        }
        
        return recipeList; 
    }
    
    @Test
    public void dd() throws InvalidFormatException, IOException {
    	FileRecipeRepository frr = new FileRecipeRepository();
    	List<Recipe> results = frr.query("브랜디에 절인 체리");
    	
    	for(Recipe recipe : results) {
    		System.out.println(recipe);
    	}
    }
    
}


