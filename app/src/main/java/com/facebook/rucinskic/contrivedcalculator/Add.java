package com.facebook.rucinskic.contrivedcalculator;

public class Add implements IOperationStrategy {

    @Override
    public double executeOperation(final double a, final double b) { return a + b; }

}
