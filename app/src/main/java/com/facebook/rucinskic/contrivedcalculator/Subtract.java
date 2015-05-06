package com.facebook.rucinskic.contrivedcalculator;

public class Subtract implements IOperationStrategy {

    @Override
    public double execute(final double a, final double b) { return b - a; }

}
