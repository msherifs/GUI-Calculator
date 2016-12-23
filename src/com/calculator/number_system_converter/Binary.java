package com.calculator.number_system_converter;

/**
 * Created by mohamedsherif on 12/21/16.
 */
public class Binary extends NumberType {

    public Binary(String binaryValue){
        this.value = binaryValue;
        this.decimalRepresentaion = Integer.parseUnsignedInt(this.value,2);

    }
    public Binary(int decimalValue){
        this.decimalRepresentaion = decimalValue;
        value = Integer.toBinaryString(decimalRepresentaion);
    }
}
