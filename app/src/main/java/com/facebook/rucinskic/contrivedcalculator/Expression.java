package com.facebook.rucinskic.contrivedcalculator;

public class Expression {

    private Builder builder;

    private Expression(Builder builder) { this.builder = builder; }

    public double getFirstNumber() { return builder.number1; }
    public double getSecondNumber() { return builder.number2; }
    public double getTotal () { return builder.total; }
    public String getOperator() { return builder.operator; }

    public static class Builder {

        private double number1, number2, total;
        private String operator;

        public Builder setFirstNumber(double number) { number1 = number; return this; }
        public Builder setSecondNumber(double number) { number2 = number; return this; }
        public Builder setOperator(String sign) { operator = sign; return this; }
        public Builder setTotal (double number) { total = number; return this; }

        public Expression toExpression() { return new Expression(this); }

    }

}
