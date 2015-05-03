package com.facebook.rucinskic.contrivedcalculator;

public enum BinaryOperation {

    Add         (new Operation(new Add())),
    Subtract    (new Operation(new Subtract())),
    Multiply    (new Operation(new Multiply())),
    Divide      (new Operation(new Divide()));

    private final Operation operation;

    BinaryOperation(Operation operation) { this.operation = operation; }

    public Operation getOperation() { return this.operation; }

}
