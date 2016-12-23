package com.calculator.number_system_converter;

/**
 * Created by mohamedsherif on 12/22/16.
 */
public class Octal extends NumberType {
    public Octal(int decimalValue){
        this.decimalRepresentaion = decimalValue;
        this.value = Integer.toOctalString(this.decimalRepresentaion);
    }

    public Octal(String octalValue){
        this.value = octalValue;
        this.decimalRepresentaion = Integer.parseUnsignedInt(value,8);
    }
}
