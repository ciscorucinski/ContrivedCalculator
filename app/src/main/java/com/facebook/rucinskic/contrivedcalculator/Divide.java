package com.facebook.rucinskic.contrivedcalculator;

public class Divide implements IOperationStrategy {

    @Override
    public double executeOperation(double a, double b) { return b / a; }

}