package com.calculator.number_system_converter;

/**
 * Created by mohamedsherif on 12/21/16.
 */
public class ConvertOctal extends NumberSystemConverter {

    @Override
    public NumberType convert() {
        return new Octal(this.number.decimalRepresentaion);
    }
}
