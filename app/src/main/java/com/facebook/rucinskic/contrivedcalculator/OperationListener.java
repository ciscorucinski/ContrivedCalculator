package com.facebook.rucinskic.contrivedcalculator;

import android.view.View;

public class OperationListener implements View.OnClickListener {

    Calculator UI;
    Operation operation;

    double num1, num2, total;

    public OperationListener(Calculator UI, BinaryOperation operator) {

        this.UI = UI;

        switch (operator) {

            case Add:         operation = operator.getOperation(); break;
            case Subtract:    operation = operator.getOperation(); break;
            case Multiply:    operation = operator.getOperation(); break;
            case Divide:      operation = operator.getOperation(); break;

        }

    }

    @Override
    public void onClick(View v) {

        num1 = Double.parseDouble(UI.txtNumber1.getText().toString());
        num2 = Double.parseDouble(UI.txtNumber2.getText().toString());

        total = operation.execute(num1, num2);

        UI.txtResult.setText(Double.toString(total));

    }

}
