package com.facebook.rucinskic.contrivedcalculator;

import android.view.View;

public class OperationClick {

    BinaryOperation operator;
    View.OnClickListener listener;

    public OperationClick(BinaryOperation operator) { this.operator = operator; }

    public View.OnClickListener listenerOn(final Calculator UI) {

        if (listener != null) return listener;
        return listener = new View.OnClickListener() {

            double  num1, num2, total;
            String result;
            Operation operation = operator.getOperation();

            @Override
            public void onClick(View v) {

                num1 = Double.parseDouble(UI.txtNumber1.getText().toString());
                num2 = Double.parseDouble(UI.txtNumber2.getText().toString());

                total = operation.execute(num1, num2);
                result = String.format("%s %s %s = %s", num1, operator.getSymbol(), num2, total);

                UI.txtResult.setText(result);

            }

        };

    }

}
