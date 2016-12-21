package com.calculator.history;

import com.calculator.equation.Equation;

import java.util.ArrayList;

public class StepData {

    private Operation operationMade;
    private double num1;
    private double num2;
    private Equation equation; // in case of solving one equation and returning a point or plotting an equation
    private ArrayList<Equation> equationsToBeSolvedTogether = new ArrayList();
    private String conversionFrom;
    private String conversionTO;
    private String arthimaticOperationMade;
    private String savedString; // note that this string won't be showed to the user

    public StepData(double firstOperand, double secondOperand, String arthimaticOperationMade) {
        this.operationMade = Operation.ARTHIMATIC;
        this.num1 = firstOperand;
        this.num2 = secondOperand;
        this.arthimaticOperationMade = arthimaticOperationMade;
        this.savedString = (this.num1 + "," + this.num2 + "," + this.arthimaticOperationMade + "," + this.operationMade.name());
    }

    public StepData(double num1, String conversionFrom, String conversionTO) {
        this.operationMade = Operation.CONVERTING;
        this.num1 = num1;
        this.conversionTO = conversionTO;
        this.conversionFrom = conversionFrom;
        this.savedString = (this.num1 + "," + this.conversionFrom + "," + this.conversionTO + "," + this.operationMade.name());
    }

    public StepData(Equation e) {
        //msh hn3rf n7dyd solving wla plotting fl constructor , el controller hwa ely hy7dyd w hy += (underscore + no3 el operation(plotting wla solving))
        this.equation = e;
        this.savedString = "" + e.toString();
    }

    public StepData(ArrayList<Equation> a) {
        this.operationMade = Operation.SOLVINGMANY;
        this.equationsToBeSolvedTogether = a;

        for (Equation e : equationsToBeSolvedTogether) {
            this.savedString += (e.toString() + "_");
        }
        this.savedString += this.operationMade;

    }


    public Operation getOperationMade() {
        return this.operationMade;
    }

    public void setOperationMade(Operation op) {
        this.operationMade = op;
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

    public String getConversionFrom() {
        return this.conversionFrom;
    }

    public void setConversionFrom(String s) {
        this.conversionFrom = s;
    }

    public String getConversionTO() {
        return this.conversionTO;
    }

    public void setConversionTO(String s) {
        this.conversionTO = s;
    }

    public String getArthimaticOperationMade() {
        return this.arthimaticOperationMade;
    }

    public void setArthimaticOperationMade(String s) {
        this.arthimaticOperationMade = s;
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
