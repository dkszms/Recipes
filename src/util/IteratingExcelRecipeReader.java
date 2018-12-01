package util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.Description;
import model.DirectionElement;
import model.Ingredient;
import model.Recipe;
import model.RecipeDirection;

/**
 * TODO: iterating recipeStringParser
 * @author kbshin on 2018. 11. 28.
 */
public class IteratingExcelRecipeReader implements Iterable<Recipe> {//객체를 만들 수 없음. static만 있는 경우 사용하기 좋음
    //private Sheet
	private Iterator<Row> rowItr;

    public IteratingExcelRecipeReader(File excelFile) throws InvalidFormatException, IOException{//GUI, 너의 데이터베이스 파일 위치를 줘라.
        //excel file 자체 자격검증
    	
        //Sheet만 할당.
    	XSSFWorkbook wb = new XSSFWorkbook(excelFile);
    	
    	Sheet sheet = wb.getSheetAt(0); // sheet 1개만 사용
    	
    	rowItr= sheet.rowIterator();
    	
    }

    
    public List<Recipe> exampleMethod() throws InvalidFormatException, IOException{//FileRepository에서 다루든지 다른 통합 Reader에서 다룰 것.
        File excelFile = new File("");
        IteratingExcelRecipeReader reader = new IteratingExcelRecipeReader(excelFile);
        List<Recipe> recipes = new ArrayList<>();
        for (Recipe recipe : reader){
            recipes.add(recipe);
        }
        return recipes;
    }
    
    
    /**
     * 엑셀 파일로부터 row를 받아 각 Element들로 분리한 후 Recipe에 세팅하여 반환
     * @param recipeRow
     * @return
     */
    public static Recipe parseRecipe(Row recipeRow){
    	List<String> recipeStrings = new ArrayList<>();
    	Iterator<Cell> cellItr = recipeRow.cellIterator();
    	
    	// recipeStrings 세팅
    	while(cellItr.hasNext()) {
    		Cell cell = cellItr.next();
    		recipeStrings.add(cell.getStringCellValue());
    	}
    	
    	
        Recipe recipe = new Recipe();

        String name = recipeStrings.get(0);
        double quantity = Double.parseDouble(recipeStrings.get(1));
        String simpleDesc = recipeStrings.get(2);
        List<String> directions = recipeStrings.subList(3,recipeStrings.size()-1);
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
    //TODO: check availability of next row.
    private boolean hasNextRow(){
        return false;
    }

    @Override
    public Iterator<Recipe> iterator() {
        Iterator<Recipe> recipeIterator = new Iterator<Recipe>() {

            @Override
            public boolean hasNext() {
                //return hasNextRow();
//                throw new UnsupportedOperationException("work hard! Ahn!!");
            	System.out.println("hasnext");
            	return true;
            }

            @Override
            public Recipe next() {
                //Row -> Recipe
                //throw new UnsupportedOperationException("work hard! Ahn!!");
            	System.out.println("NEXT!!");
                return parseRecipe(rowItr.next());
            }
        };
        return recipeIterator;
    }
    
  
}
