package com.calculator.number_system_converter;

/**
 * Created by mohamedsherif on 12/21/16.
 */
public class Binary extends NumberType {

    public Binary(String binaryValue){
        this.value = binaryValue;

    }
    public Binary(int decimalValue){
        this.decimalRepresentaion = decimalValue;
    }

    @Override
    protected void convertToDecimal(){

    }
}
