package com.facebook.rucinskic.contrivedcalculator;

public class Subtract implements IOperationStrategy {

    @Override
    public double executeOperation(final double a, final double b) { return b - a; }

}
