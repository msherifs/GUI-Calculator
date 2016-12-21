package com.calculator.equation;


public class Equation {

    private double[] oneVarQuadricCoefficients = new double[3];
    private double xCoefficient;
    private double yCoefficient;
    private double zCoefficient;
    private double constant;
    private String equationFormula; // note that this string won't be showed to the user


    public Equation(double a, double b, double c, double f) {

        this.xCoefficient = a;
        this.yCoefficient = b;
        this.zCoefficient = c;
        this.constant = f;
        this.equationFormula = "  " + a + " , " + b + " , " + c + " , " + f;

    }

    public Equation(double[] a) {
        this.oneVarQuadricCoefficients = a;
        this.equationFormula = "  " + a[0] + " , " + a[1] + " , " + a[2];

    }

    public double getxCoefficient() {
        return this.xCoefficient;
    }

    public void setxCoefficient(double a) {
        this.xCoefficient = a;
    }

    public double getyCoefficient() {
        return this.yCoefficient;
    }

    public void setyCoefficient(double a) {
        this.yCoefficient = a;
    }

    public double getzCoefficient() {
        return this.zCoefficient;
    }

    public void setzCoefficient(double a) {
        this.zCoefficient = a;
    }

    public double getConstant() {
        return this.constant;
    }

    public void setConstant(double a) {
        this.constant = a;
    }

    public double[] getOneVarQuadricCoefficients() {
        return this.oneVarQuadricCoefficients;
    }

    public void setOneVarQuadricCoefficients(double[] a) {
        this.oneVarQuadricCoefficients = a;

    }


    public String toString() {
        return this.equationFormula;
    }

}
