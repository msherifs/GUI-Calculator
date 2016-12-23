package com.calculator.number_system_converter;

/**
 * Created by mohamedsherif on 12/22/16.
 */
public class Hexadecimal extends NumberType{
    public Hexadecimal(String hexadecimal){
        this.value = hexadecimal;
        this.decimalRepresentaion = Integer.parseUnsignedInt(value,16);
    }

    public Hexadecimal(int decimalValue){
        this.decimalRepresentaion = decimalValue;
        this.value = Integer.toHexString(this.decimalRepresentaion);
    }
}
