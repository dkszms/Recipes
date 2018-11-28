package repository;

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

import model.Description;
import model.DirectionElement;
import model.Ingredient;
import model.Recipe;
import model.RecipeDirection;

/**
 * TODO: Repository로 재작성.
 */
public class FileRecipeRepository {
	//1. initialize 
	
	
	public FileRecipeRepository() throws InvalidFormatException, IOException {
		// 파일을 읽어온다.
		File file = new File ("E:\\Git\\GIT Project\\Recipes\\경레시피.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(file);
		
		Sheet sheet = wb.getSheetAt(0);
		
		List<Recipe> recipeList = new ArrayList<>();
		// POi를 사용해서 1row를 받아온다.
		for(Row row : sheet) {
			//row의 Cell 1,2,3,을 name, qty, simpledesc로 정의
			//4번째 이상의 cell은 정규식을 통해 나눈 후 Direction 생성
			Recipe recipe = makeRecipe(row);
			recipeList.add(recipe);
		}
		
		//마지막에 List<Recipe>
		//엑셀 파일을 읽어서 데이터 가져오고
		//한 줄 -> name, qty, simpleDescription, List<RecipeDerection>
		
	}
}
