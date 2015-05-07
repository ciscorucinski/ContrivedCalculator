package com.facebook.rucinskic.contrivedcalculator;

import android.view.View;

public class OperationClick {

    private BinaryOperation operation;
    private View.OnClickListener listener;

    public OperationClick(final BinaryOperation operation) { this.operation = operation; }

    public View.OnClickListener listenerOn(final ICalculatorInteraction UI) {

        if (listener != null) return listener;
        return listener = new View.OnClickListener() {

            double  num1, num2, total;
            String result, sign;

            @Override
            public void onClick(View v) {

                num1 = Double.parseDouble(UI.getFirstNumber());
                num2 = Double.parseDouble(UI.getSecondNumber());
                total = operation.execute(num1, num2);
                sign = operation.getSymbol();

                result = String.format("%s %s %s = %s", num1, sign, num2, total);

                UI.updateResult(result);

            }

        };

    }

}
