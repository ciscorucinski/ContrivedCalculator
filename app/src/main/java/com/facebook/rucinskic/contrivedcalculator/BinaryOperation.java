package com.facebook.rucinskic.contrivedcalculator;

import static com.facebook.rucinskic.contrivedcalculator.BinaryOperation.Display.NOUN;
import static com.facebook.rucinskic.contrivedcalculator.BinaryOperation.Display.SIGN;
import static com.facebook.rucinskic.contrivedcalculator.BinaryOperation.Display.VERB;

public enum BinaryOperation implements IOperationStrategy {

    Add     (new OperationDisplay.Builder()
                    .set(SIGN, "+")
                    .set(VERB, "Add")
                    .set(NOUN, "Addition")
                    .build()) {

        @Override
        public double execute(final double a, final double b) { return a + b; } },

    Subtract (new OperationDisplay.Builder()
                    .set(SIGN, "-")
                    .set(VERB, "Subtract")
                    .set(NOUN, "Subtraction")
                    .build()) {

        @Override
        public double execute(final double a, final double b) { return a - b; } },

    Multiply (new OperationDisplay.Builder()
                    .set(SIGN, "×")
                    .set(VERB, "Multiply")
                    .set(NOUN, "Multiplication")
                    .build()) {

        @Override
        public double execute(final double a, final double b) { return a * b; } },

    Divide   (new OperationDisplay.Builder()
                    .set(SIGN, "÷")
                    .set(VERB, "Divide")
                    .set(NOUN, "Division").build()) {

        @Override
        public double execute(final double a, final double b) { return a / b; } };

    private final OperationDisplay operation;
    private Display display;

    BinaryOperation(OperationDisplay operation) { this.operation = operation; }

    public  void setDisplayMode(Display mode) { this.display = mode; }

    @Override
    public String toString() { return this.operation.get(display); }

    public enum Display { SIGN, VERB, NOUN }

}
