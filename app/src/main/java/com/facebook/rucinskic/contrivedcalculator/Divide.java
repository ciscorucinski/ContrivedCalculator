package com.facebook.rucinskic.contrivedcalculator;

public class Divide implements IOperationStrategy {

    @Override
    public double executeOperation(final double a, final double b) { return b / a; }

}