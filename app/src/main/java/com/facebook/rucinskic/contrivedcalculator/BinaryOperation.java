package com.facebook.rucinskic.contrivedcalculator;

public enum BinaryOperation {

    Add         ("+", new Operation(new Add())),
    Subtract    ("-", new Operation(new Subtract())),
    Multiply    ("×", new Operation(new Multiply())),
    Divide      ("÷", new Operation(new Divide()));

    private final Operation operation;
    private final String symbol;

    BinaryOperation(final String symbol, final Operation operation) {

        this.operation = operation;
        this.symbol = symbol;

    }

    public Operation getOperation() { return this.operation; }
    public String getSymbol() { return this.symbol; }

}
