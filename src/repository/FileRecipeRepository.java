package repository;

import java.util.ArrayList;
import java.util.List;

import model.Recipe;

public class FileRecipeRepository {
	
	private List<Recipe> recipeList;
	//private io 관련 하나 추가. add 했을 때 해당 파일에 써야 할 것. RecipeRepositoryWriter -> ExcelRecipeRepositoryWriter

    FileRecipeRepository(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    public void add(Recipe recipe){
        recipeList.add(recipe);
    }

    public void update(Recipe recipe){
        throw new UnsupportedOperationException("검색 메소드 상세 구현 이후에 구현될 예정.");
//        for (Recipe repoRecipe: recipeList) {
//            if (repoRecipe.equals(recipe)){//검색 메소드 받아와서 적용.
//                repoRecipe = recipe;
//            }
//        }
    }

    public void remove(Recipe recipe){
        recipeList.remove(recipe);
    }

    public List<Recipe> getAll(){
        return recipeList;
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
}
