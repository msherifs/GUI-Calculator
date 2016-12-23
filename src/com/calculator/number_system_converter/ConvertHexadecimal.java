package com.calculator.number_system_converter;

/**
 * Created by mohamedsherif on 12/21/16.
 */
public class ConvertHexadecimal extends NumberSystemConverter {
    public ConvertHexadecimal(NumberType number){
        this.number = number;
    }
    @Override
    public NumberType convert() {
        return new Hexadecimal(this.number.decimalRepresentaion);
    }
}
