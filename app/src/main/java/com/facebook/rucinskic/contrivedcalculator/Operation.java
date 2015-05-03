package com.facebook.rucinskic.contrivedcalculator;

/**
 * Created by Christopher on 5/3/2015.
 */
public class Operation {

    private IOperationStrategy operator;

    public Operation(IOperationStrategy operator) { this.operator = operator; }

    public double execute(double a, double b) { return this.operator.executeOperation(a, b); }

}
