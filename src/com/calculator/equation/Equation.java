package com.calculator.equation;


import java.util.ArrayList;
import java.util.Arrays;

public class Equation {
    //CHANGED IMPLEMENTATION BECAUSE THIS IS A LINEAR EQUATION NOT GENERAL EQUATION

    private ArrayList<Coefficient> equation = new ArrayList<Coefficient>();

    public Equation(Coefficient [] coefficientsArray){
        equation.addAll(Arrays.asList(coefficientsArray));
    }

    public Equation(ArrayList<Coefficient> coefficientArrayList){
        equation.addAll(coefficientArrayList);
    }

    public void addCoefficient(double value, int power){
        equation.add(new Coefficient(value, power));
    }

    public double evaluateHigherDegree(double valueOfVariable){
        double value = 0;
        for (Coefficient c : equation){
            value += Math.pow(c.getValue(),(double)c.getPower());
        }
        return value;
    }

    public double evaluateLinear(double [] valueOfVariables){
        double value = 0;
        if(valueOfVariables.length != equation.size()){
            return -1.1; // we should replace the if condition with exception
        }
        for (int i = 0 ; i < valueOfVariables.length ; i++){
            value += (equation.get(i).getValue() * valueOfVariables[i]) ;
        }
        return value;
    }

    public ArrayList<Coefficient> getEquation() {
        return equation;
    }

    public String toString() {
        String fString = "";
        for (int i = 0 ; i < equation.size() ; i++){
            fString += equation.get(i).getValue() + "," + equation.get(i).getPower();
            if (i != equation.size()-1 ){
                fString += "_";
            }
        }
        return fString;
    }
}
