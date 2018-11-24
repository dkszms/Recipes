package model;

import java.util.List;

/**
 *
 * @author kbshin on 2018. 11. 24.
 */
public class RecipeDirection {
    private List<DirectionElement> directionElements;
    private double originalQuantity;
    private double requestedQuantity;

    public RecipeDirection(List<DirectionElement> directionElements, double originalQuantity) {
        this.directionElements = directionElements;
        this.originalQuantity = originalQuantity;
        this.requestedQuantity = this.originalQuantity;
    }
/**
    public RecipeDirection(String stepDesc, String ingredients) {

    }
*/
    public String getDescriptionString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (DirectionElement element : this.directionElements){
            stringBuilder.append(element.toString());
        }
        return stringBuilder.toString().trim();
    }

    public void setQuantity(double quantity) {
        this.requestedQuantity = quantity;
        renewDirection();
    }

    private void renewDirection(){
        for (DirectionElement element : this.directionElements){
            element.setCoefficient(requestedQuantity/originalQuantity);
        }
    }
}
