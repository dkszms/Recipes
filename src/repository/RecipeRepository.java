package repository;

import java.util.List;

import model.Recipe;


//TODO 인터페이스화 한다.
public interface RecipeRepository {
	
	public List<Recipe> query(String recipeName) ;

}
