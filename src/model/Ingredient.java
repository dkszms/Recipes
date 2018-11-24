package model;

/**
 *
 * @author kbshin on 2018. 11. 24.
 */
public class Ingredient implements DirectionElement{
    private String name;
    private double amount;
    private String unit;

    private double coefficient;

    public Ingredient(String name, double amount, String unit) {
        this.name = name;
        this.amount = amount;
        this.unit = unit;
        this.coefficient = 1.0;
    }

    @Override
    public boolean isIngredient() {
        return true;
    }

    @Override
    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public String toString() {
        return name +' '+ String.format("%.2f", amount*coefficient) + unit;
    }
}
