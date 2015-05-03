package com.facebook.rucinskic.contrivedcalculator;

/**
 * Created by Christopher on 5/3/2015.
 */
public class Multiply implements IOperationStrategy {

    @Override
    public double executeOperation(double a, double b) { return a * b; }

}
