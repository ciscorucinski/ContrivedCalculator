package com.facebook.rucinskic.contrivedcalculator;

public class Operation {

    IOperationStrategy operation;

    Operation(IOperationStrategy operation) { this.operation = operation; }

    public double execute(double a, double b) { return operation.executeOperation(a, b); }

}
