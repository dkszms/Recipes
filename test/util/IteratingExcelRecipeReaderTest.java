package util;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

/**
 * ${MyName}
 *
 * @author kbshin on 2018. 11. 28.
 * @project Recipes
 */
public class IteratingExcelRecipeReaderTest {

    private void init(){

    }

    @Test
    public void testParseRecipe() throws InvalidFormatException, IOException {
		// 파일을 읽어온다.
		File file = new File ("E:\\Git\\GIT Project\\Recipes\\경레시피.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(file);

		Sheet sheet = wb.getSheetAt(0);
		
		
		
//		List<Recipe> recipeList = new ArrayList<>();
//		// POi를 사용해서 1row를 받아온다.
//		IteratingExcelRecipeReader iter = new IteratingExcelRecipeReader(file);
//		for(Recipe recipe : iter) {
//			recipeList.add(recipe);
//		}
    }
}