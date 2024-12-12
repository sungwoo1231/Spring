package com.dw.jdbcapp.model;

public class MileGrade  {
   private String gradeName;
   private int lowerMileage;
   private int upperMileage;

    public MileGrade(String gradeName, int lowerMileage, int upperMileage) {
        this.gradeName = gradeName;
        this.lowerMileage = lowerMileage;
        this.upperMileage = upperMileage;
    }

    public MileGrade() {
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public int getLowerMileage() {
        return lowerMileage;
    }

    public void setLowerMileage(int lowerMileage) {
        this.lowerMileage = lowerMileage;
    }

    public int getUpperMileage() {
        return upperMileage;
    }

    public void setUpperMileage(int upperMileage) {
        this.upperMileage = upperMileage;
    }

    @Override
    public String toString() {
        return "MileGrade{" +
                "gradeName='" + gradeName + '\'' +
                ", lowerMileage=" + lowerMileage +
                ", upperMileage=" + upperMileage +
                '}';
    }
}
