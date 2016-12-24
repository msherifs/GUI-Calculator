package com.calculator.equation;

/**
 * Created by mohamedsherif on 12/24/16.
 */
public class Coefficient {
    protected double value;
    protected int power;

    public Coefficient(double value, int power) {
        this.value = value;
        this.power = power;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
