package com.facebook.rucinskic.contrivedcalculator;

public class Number extends java.lang.Number {

    private double number;

    public Number() { this(0);}
    public Number(double number) { this.number = number; }


    @Override
    public String toString() {

        return number == longValue()
                ? String.valueOf(longValue())
                : String.valueOf(number);

    }

    @Override public double doubleValue()   { return number; }
    @Override public float floatValue()     { return (float) number; }
    @Override public int intValue()         { return (int) number; }
    @Override public long longValue()       { return (long) number; }

}
