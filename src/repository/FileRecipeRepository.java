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
	
	public Recipe makeRecipe(Row row) {
		//row에서 cell을 받아온다.
		
		List<String> cellData = getCelldata(row);
		
		//cell 1,2,3은 name, qty, simpledesc로 정의
		String name;
		double quantity;
		String simpleDesc;
		List<String> directions;
		
		Recipe recipe = new Recipe();
		//4번째 이상의 cell은 정규식을 통해 나눈 후 Direction 생성
		List<RecipeDirection> recipeDirections = parseDirections(directions, quantity);
		// 
		recipe.setDirections(recipeDirections);
		
				
		return recipe;
		
	}
	
	private List<RecipeDirection> parseDirections(List<String> directions, double originalQuantity){
		List<RecipeDirection> recipeDirections= new ArrayList<>();
		for(String str : directions) {
			RecipeDirection recipeDirection = parseDirection(str, originalQuantity);
			recipeDirections.add(recipeDirection);
		}
		
		return recipeDirections;
	}

	private RecipeDirection parseDirection(String str, double originalQuantity) {
		//정규식 구현
		
		List<DirectionElement> directionElements = getDirectionElements(str);
		RecipeDirection recipedirection= new RecipeDirection(directionElements, originalQuantity);
		
		return recipedirection;
	}
	
	public List<DirectionElement> getDirectionElements(String str){
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
	
	private Ingredient getIngredient(String ingredientStr) {
		
		String[] ings  = ingredientStr.substring(1, ingredientStr.length()-1).split(",");
		String name = ings[0];
		double amount = Double.parseDouble(ings[1]);
		String unit = ings[2];
		
		return new Ingredient(name, amount, unit);
	}
}
