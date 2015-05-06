package com.facebook.rucinskic.contrivedcalculator;

public class Add implements IOperationStrategy {

    @Override
    public double execute(final double a, final double b) { return a + b; }

}
