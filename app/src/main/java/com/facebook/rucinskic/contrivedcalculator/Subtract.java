package com.facebook.rucinskic.contrivedcalculator;

public class Subtract implements IOperationStrategy {

    @Override
    public double executeOperation(double a, double b) { return b - a; }

}
