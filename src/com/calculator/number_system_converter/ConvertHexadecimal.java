package com.calculator.number_system_converter;

/**
 * Created by mohamedsherif on 12/21/16.
 */
public class ConvertHexadecimal extends NumberSystemConverter {
    @Override
    public NumberType convert(NumberType a) {
        return new Hexadecimal(a.decimalRepresentaion);
    }
}
