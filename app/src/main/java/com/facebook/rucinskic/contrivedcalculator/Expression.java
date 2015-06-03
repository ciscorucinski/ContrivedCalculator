package com.facebook.rucinskic.contrivedcalculator;

public class Expression {

    private final Builder builder;

    private Expression(Builder builder) { this.builder = builder; }

    public double getFirstNumber() { return builder.number1; }
    public double getSecondNumber() { return builder.number2; }
    public double getTotal () { return builder.total; }
    public BinaryOperation getOperator() { return builder.operator; }

    public static class Builder {

        private double number1, number2, total;
        private BinaryOperation operator;

        public Builder setFirstNumber(double number) { number1 = number; return this; }
        public Builder setSecondNumber(double number) { number2 = number; return this; }
        public Builder setOperator(BinaryOperation sign) { operator = sign; return this; }
        public Builder setTotal (double number) { total = number; return this; }

        public Expression toExpressionFor(ICalculatorInteraction UI) {

            operator.setDisplayMode(UI.getOperationDisplayMode());
            return new Expression(this);

        }

    }

}
