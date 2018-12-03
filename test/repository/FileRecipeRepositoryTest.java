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
    private File file = new File ("resource/recipe_test.xlsx");

    /**
     * Test method testing query() of FileRecipeRepository
     * @throws InvalidFormatException If a file is not ms excel file.
     * @throws IOException If a file does not exists.
     */
    @Test
    public void testQuery() throws InvalidFormatException, IOException {
    	FileRecipeRepository frr = ExcelFileRecipeRepositoryBuilder.getInstance(file);
    	List<Recipe> results = frr.query("브랜디에 절인 체리");
    	//Test resource 추가 요망: 브랜디, 체리 등 키워드를 공유하는 다른 레시피
        //client와 다시 논의 필요: 재료가지고 할 건지?
    	//기본적인 기능 테스트(best)
        for (Recipe recipe: results){
    	    assertTrue(recipe.getRecipeName().contains("브랜디에 절인 체리"));
        }
        //worst: List<Recipe> results = frr.query("Brandy");//영어 등 검색 불가능한 조건을 사용할 경우
        //-->error 메시지를 만들어줘야한다.
    }
    
}


