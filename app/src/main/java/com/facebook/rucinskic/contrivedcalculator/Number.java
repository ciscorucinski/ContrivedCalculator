package com.facebook.rucinskic.contrivedcalculator;

import java.text.DecimalFormat;

public class Number extends java.lang.Number {

    private double number;
    private static DecimalFormat defaultFormatter;
    private DecimalFormat overridingFormatter;

    public Number() { this(0);}
    public Number(double number) { this.number = number; }


    @Override
    public String toString() {

        if (overridingFormatter != null) return overridingFormatter.format(number);
        if (defaultFormatter != null) return defaultFormatter.format(number);

        return (number == longValue())
                ? String.valueOf(longValue())
                : String.valueOf(number);

    }

    @Override public double doubleValue()   { return number; }
    @Override public float floatValue()     { return (float) number; }
    @Override public int intValue()         { return (int) number; }
    @Override public long longValue()       { return (long) number; }

    public static void setDefaultMaximumDecimalPlaces(int decimalPlaces) {

        defaultFormatter = getFormat(decimalPlaces);

    }

    public Number setDecimalPlace(int decimalPlaces) {

        overridingFormatter = getFormat(decimalPlaces);
        return this;

    }

    private static DecimalFormat getFormat(int decimalPlaces) {

        StringBuilder places = new StringBuilder("#,##0.");

        for (int i = 0; i < decimalPlaces; i++) places.append('#');

        return  new DecimalFormat(places.toString());

    }

}
