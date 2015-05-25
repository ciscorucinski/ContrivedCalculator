package com.facebook.rucinskic.contrivedcalculator;

public enum BinaryOperation implements IOperationStrategy {

    Add      ("+") { @Override public double execute(final double a, final double b) { return a + b; } },
    Subtract ("-") { @Override public double execute(final double a, final double b) { return a - b; } },
    Multiply ("×") { @Override public double execute(final double a, final double b) { return a * b; } },
    Divide   ("÷") { @Override public double execute(final double a, final double b) { return a / b; } };

    private final String symbol;

    // abstract double execute(double a, double b);  // Could use this instead of an Interface

    BinaryOperation(String symbol) { this.symbol = symbol; }

    public String getSymbol() { return this.symbol; }

    // The below code is for Android when it supports lambdas

//    Add      ("+", ((x, y) -> x + y)),
//    Subtract ("-", ((x, y) -> x - y)),
//    Multiply ("×", ((x, y) -> x * y)),      // Must use Gradle 2.3 or higher. File >> Project Structure >> Project >> Gradle Version >> 2.3
//    Divide   ("÷", ((x, y) -> x / y));
//
//    private final String symbol;
//    private final IOperationStrategy strategy;
////
//     BinaryOperation(String symbol, IOperationStrategy strategy) {
//
//         this.symbol = symbol;
//         this.strategy = strategy;  // This can be removed
//
//    }
//
//    public String getSymbol() { return this.symbol; }
//    public double execute(double a, double b) { return this.strategy.execute(a, b); }

}
