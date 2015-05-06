package com.facebook.rucinskic.contrivedcalculator;

import android.view.View;

public class OperationClick {

    private BinaryOperation operator;
    private View.OnClickListener listener;

    public OperationClick(final BinaryOperation operator) { this.operator = operator; }

    public View.OnClickListener listenerOn(final ICalculatorInteraction UI) {

        if (listener != null) return listener;
        return listener = new View.OnClickListener() {

            double  num1, num2, total;
            String result, sign;
            Operation operation = operator.getOperation();

            @Override
            public void onClick(View v) {

                num1 = Double.parseDouble(UI.getFirstNumber());
                num2 = Double.parseDouble(UI.getSecondNumber());
                total = operation.execute(num1, num2);
                sign = operator.getSymbol();

                result = String.format("%s %s %s = %s", num1, sign, num2, total);

                UI.updateResult(result);

            }

        };

    }

}
