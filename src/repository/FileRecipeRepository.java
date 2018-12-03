package repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.Recipe;
import util.IteratingExcelRecipeReader;

/**
 * TODO: Repository로 재작성.
 */
public class FileRecipeRepository {
	
	static List<Recipe> recipeList = new ArrayList<>();
	
	//1. initialize
	public FileRecipeRepository() throws InvalidFormatException, IOException {
		// 파일을 읽어온다.
		File file = new File ("resource/recipe_test.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(file);
		
		Sheet sheet = wb.getSheetAt(0);
		
		if(checkFileExtention(file)) {
			IteratingExcelRecipeReader iter = new IteratingExcelRecipeReader(file); // 엑셀 파일을 조회하여 iterater를 생성한다.
	        for(Recipe recipe : iter) {
	            recipeList.add(recipe);
	        }
		}else {
			System.out.println("입력 된 파일이 xlsx형식의 엑셀파일이 아닙니다.");
		}
		
	}
	
	public List<Recipe> query(String keyword) {
		List<Recipe> resultList = new ArrayList<>();
		for(Recipe recipe : recipeList) {
			if(recipe.getRecipeName().contains(keyword)) {
				resultList.add(recipe);
			}
		}
		
		return resultList;
	}

	
	public boolean checkFileExtention(File file){
		   String fileName = file.getName();
		   String ext = fileName.substring(fileName.indexOf(".")+1, fileName.length());
		   boolean isXlsx = false;
		   
		   if(ext.equals("xlsx")) {
			  isXlsx = true;
		   }
		return isXlsx;
	}
}
