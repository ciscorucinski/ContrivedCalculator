package com.facebook.rucinskic.contrivedcalculator;

import android.view.View;

public class OperationClick {

    Operation operation;
    View.OnClickListener listener;

    public OperationClick(BinaryOperation operator) {

        this.operation = operator.getOperation();

    }

    public View.OnClickListener listenerOn(final Calculator UI) {

        if (listener != null) return listener;
        return listener = new View.OnClickListener() {

            double num1, num2, total;

            @Override
            public void onClick(View v) {

                num1 = Double.parseDouble(UI.txtNumber1.getText().toString());
                num2 = Double.parseDouble(UI.txtNumber2.getText().toString());

                total = operation.execute(num1, num2);

                UI.txtResult.setText(Double.toString(total));

            }

        };

    }

}
