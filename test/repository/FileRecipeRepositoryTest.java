package repository;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import model.Recipe;
import util.IteratingExcelRecipeReader;

class FileRecipeRepositoryTest {

	@Test
	void testFileRecipeRepository() throws InvalidFormatException, IOException {
		// 파일을 읽어온다.
		File file = new File ("E:\\Git\\GIT Project\\Recipes\\경레시피.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(file);
		
		Sheet sheet = wb.getSheetAt(0);
		
		List<Recipe> recipeList = new ArrayList<>();
		// POi를 사용해서 1row를 받아온다.
		IteratingExcelRecipeReader iter = new IteratingExcelRecipeReader(file);
		for(Recipe recipe : iter) {
			recipeList.add(recipe);
		}
		
		//마지막에 List<Recipe>
		//엑셀 파일을 읽어서 데이터 가져오고
		//한 줄 -> name, qty, simpleDescription, List<RecipeDerection>
	}

	@Test
	void testMakeRecipe() {
		fail("Not yet implemented");
	}
	
//	@Test
//	public void testGetDirectionElements(){
//      
//      String str = "[씨를 제거한 체리, 7, cup]에 [설탕, 450, g]과 [브랜디, 60, ml]를 섞어서 하룻밤 재어놓는다.";
//      System.out.println(str);
//      
//      Pattern p = Pattern.compile("\\[.*?\\]");
//      Matcher m = p.matcher(str);
//    
//      FileRecipeRepository frr = new FileRecipeRepository();
//      
//      
//	      
//	}
	
	
}
