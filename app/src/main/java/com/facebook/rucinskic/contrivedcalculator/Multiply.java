package com.facebook.rucinskic.contrivedcalculator;

public class Multiply implements IOperationStrategy {

    @Override
    public double executeOperation(final double a, final double b) { return a * b; }

}