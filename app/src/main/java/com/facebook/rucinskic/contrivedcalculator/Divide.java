package com.facebook.rucinskic.contrivedcalculator;

public class Divide implements IOperationStrategy {

    @Override
    public double execute(final double a, final double b) { return b / a; }

}