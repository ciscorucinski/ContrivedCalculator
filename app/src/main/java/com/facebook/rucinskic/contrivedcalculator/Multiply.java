package com.facebook.rucinskic.contrivedcalculator;

public class Multiply implements IOperationStrategy {

    @Override
    public double executeOperation(double a, double b) { return a * b; }

}