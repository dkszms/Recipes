package repository;

import model.Recipe;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import util.IteratingExcelRecipeReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kbshin on 2018. 12. 3.
 */
public class ExcelFileRecipeRepositoryBuilder {
    public static FileRecipeRepository getInstance(File excelFile) throws IOException, InvalidFormatException {
        List<Recipe> recipeList = new ArrayList<>();
        File file = new File ("resource/recipe_test.xlsx");

        if(checkFileExtention(file)) {
            IteratingExcelRecipeReader iter = new IteratingExcelRecipeReader(file); // 엑셀 파일을 조회하여 iterater를 생성한다.
            for(Recipe recipe : iter) {
                recipeList.add(recipe);
            }
        } else {
            System.out.println("입력 된 파일이 xlsx형식의 엑셀파일이 아닙니다.");
        }

        return new FileRecipeRepository(recipeList);
    }

    private static boolean checkFileExtention(File file){
        String fileName = file.getName();
        String ext = fileName.substring(fileName.indexOf(".")+1, fileName.length());
        boolean isXlsx = false;

        if(ext.equals("xlsx")) {
            isXlsx = true;
        }
        return isXlsx;
    }

}
