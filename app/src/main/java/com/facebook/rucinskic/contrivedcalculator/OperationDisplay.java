package com.facebook.rucinskic.contrivedcalculator;

import java.util.EnumMap;

import static com.facebook.rucinskic.contrivedcalculator.BinaryOperation.Display;

public class OperationDisplay {

    private EnumMap<Display, String> map;

    private OperationDisplay(Builder builder) { this.map = builder.map; }
    public String get(Display key) { return map.get(key); }

    public static class Builder {

        private EnumMap<Display, String> map = new EnumMap<>(Display.class);

        public Builder set(Display key, String value) { map.put(key, value); return this; }
        public OperationDisplay build() { return new OperationDisplay(this); }

    }

}
