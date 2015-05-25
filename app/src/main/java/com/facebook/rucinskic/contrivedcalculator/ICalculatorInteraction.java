package com.facebook.rucinskic.contrivedcalculator;

public interface ICalculatorInteraction {

    String getFirstNumber();
    String getSecondNumber();

    void updateResult(Expression result);

}
