package model;

/**
 *
 * @author kbshin on 2018. 11. 24.
 */
public class Description implements DirectionElement{
    private String desc;

    public Description(String description){
        this.desc = description;
    }

    @Override
    public boolean isIngredient() {
        return false;
    }

    @Override
    public void setCoefficient(double coefficient) {

    }
    @Override
    public String toString(){
        return desc + " ";
    }
}
