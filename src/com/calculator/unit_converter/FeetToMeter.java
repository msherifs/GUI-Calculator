package com.calculator.unit_converter;

/**
 * Created by mohamedsherif on 12/21/16.
 */
public class FeetToMeter extends UnitConverter {
    public FeetToMeter(double numA, boolean isFlipped){
        this.numA = numA;
        this.isFlipped = isFlipped;
    }

    @Override
    public double convert(){
        if (isFlipped){
            return numA * 3.28084;
        } else {
            return numA * 0.3048;
        }
    }
}
