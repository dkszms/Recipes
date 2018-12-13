package main;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import model.Recipe;
import repository.ExcelFileRecipeRepositoryBuilder;
import repository.FileRecipeRepository;
import viewer.CLRecipeViewer;
import viewer.RecipeViewer;

public class Main {
	public static void main(String[] args) throws InvalidFormatException, IOException {
        RecipeViewer rv = new CLRecipeViewer();
	    String q = "브랜디에 절인 체리";
	    File excelFile = new File("resource/recipe_test.xlsx");

		FileRecipeRepository rr = ExcelFileRecipeRepositoryBuilder.getInstance(excelFile);

		List<Recipe> recipes = rr.query(q);//search, query, 기타 등등
		//TODO 검색 결과 보여주기: 초기화면 만들기
		rv.setRecipeList(recipes);
		//검색 결과 중 하나 선택하기
		rv.setRecipe(recipes.get(0));
		//해당 recipe 해당 사항을 보여주기
		rv.show();//refresh 동작.
	}
}
