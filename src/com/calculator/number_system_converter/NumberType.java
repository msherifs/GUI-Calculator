package com.calculator.number_system_converter;

/**
 * Created by mohamedsherif on 12/18/16.
 */
public abstract class NumberType {
    protected String value;
    protected int decimalRepresentaion;
    protected abstract void convertToDecimal();
    public String getValueString(){
        return value;
    }
}