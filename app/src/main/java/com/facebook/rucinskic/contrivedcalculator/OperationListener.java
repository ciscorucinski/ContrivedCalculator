package com.facebook.rucinskic.contrivedcalculator;

import android.view.View;

public class OperationListener implements View.OnClickListener {

    Calculator UI;
    Operation operation;

    double num1, num2, total;

    public OperationListener(Calculator UI, BinaryOperation operator) {

        this.UI = UI;

        switch (operator) {

            case Add:         operation = new Operation(new Add()); break;
            case Subtract:    operation = new Operation(new Subtract()); break;
            case Multiply:    operation = new Operation(new Multiply()); break;
            case Divide:      operation = new Operation(new Divide()); break;

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
