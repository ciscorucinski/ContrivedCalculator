package com.facebook.rucinskic.contrivedcalculator;

public class Operation {

    private IOperationStrategy operation;   // Private. Disallows calling operations directly

    Operation(final IOperationStrategy operation) { this.operation = operation; }

    public double execute(final double a, final double b) { return operation.execute(a, b); }

}
