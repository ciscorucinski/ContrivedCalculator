package com.facebook.rucinskic.contrivedcalculator;

public class Add implements IOperationStrategy {

    @Override
    public double executeOperation(double a, double b) { return a + b; }

}
