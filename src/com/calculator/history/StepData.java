package com.calculator.history;

import com.calculator.equation.Equation;

import java.util.ArrayList;

public class StepData {

    private Operation operationMade;
    private double num1;
    private double num2;
    private Equation equation; // in case of solving one equation and returning a point or plotting an equation
    private ArrayList<Equation> equationsToBeSolvedTogether = new ArrayList();
    private String hexaString;
    private String savedString; // note that this string won't be showed to the user
 int i =0 ;
    public StepData(double firstOperand, double secondOperand, Operation operation) {
        this.num1 = firstOperand;
        this.num2 = secondOperand;
        this.operationMade= operation;
        this.savedString = (this.num1 + "," + this.num2 + ","  + this.operationMade.name());
    }

    public StepData(double num1,Operation a) {
        this.num1 = num1;
       this.operationMade = a ;
        this.savedString = (this.num1 + "," + this.operationMade.name());
    }
    public StepData(String num1,Operation a) {
        this.hexaString = num1;
        this.operationMade = a ;
        this.savedString = (this.num1 + "," +  this.operationMade.name());
    }

    public StepData(Equation e, Operation op) {
        this.equation = e;
        this.savedString = "" + e.toString() + op.name();
        this.operationMade = op;
    }

    public StepData(ArrayList<Equation> a , Operation op) {
        this.equationsToBeSolvedTogether = a;
        this.operationMade=op ;
        for (Equation e : equationsToBeSolvedTogether) {
            i++;
            this.savedString += (e.toString() );
            if (i != equationsToBeSolvedTogether.size()-1 ){
                this.savedString += "_";
            }
        }
        this.savedString += this.operationMade;

    }

    public Operation getOperationMade() {
        return this.operationMade;
    }


    public double getNum1() {
        return this.num1;
    }

    public void setNum1(double n) {
        this.num1 = n;
    }

    public double getNum2() {
        return this.num2;
    }

    public void setNum2(double n) {
        this.num2 = n;
    }

    public Equation getEquation() {
        return this.equation;
    }

    public void setEquation(Equation e) {
        this.equation = e;
    }


    public ArrayList<Equation> getStringList() {
        return this.equationsToBeSolvedTogether;
    }

    public void setSavedString(String a) {
        this.savedString = a;
    }

    public String toString() {
        return this.savedString;

    }

}
