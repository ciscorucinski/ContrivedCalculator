package com.facebook.rucinskic.contrivedcalculator;

import android.os.Bundle;
import android.widget.EditText;

public class CalculatorStatic extends BaseCalculatorActivity {

    EditText txtNumber1, txtNumber2, txtResult;

    private static final String PI = String.valueOf(Math.PI);
    private static final String PHI = String.valueOf((Math.sqrt(5) + 1) / 2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        initializeOperationButtons();

        txtNumber1 = (EditText) findViewById(R.id.txtNumber1);
        txtNumber2 = (EditText) findViewById(R.id.txtNumber2);
        txtResult = (EditText) findViewById(R.id.txtResult);

        txtNumber1.setEnabled(false);
        txtNumber2.setEnabled(false);
        txtNumber1.setText(PI);
        txtNumber2.setText(PHI);
        txtResult.setSelected(true);

    }

    @Override
    public String getFirstNumber() { return PI; }

    @Override
    public String getSecondNumber() { return PHI; }

    @Override
    public void updateResult(Expression result) {

        Number.setDefaultMaximumDecimalPlaces(6);

        String expression = String.format(
                "%s %s %s = %s",
                new Number(result.getFirstNumber()),
                result.getOperator(getOperationDisplayMode()),
                new Number(result.getSecondNumber()),
                new Number(result.getTotal()).setDecimalPlace(10));

        txtResult.setText(expression);

    }
}
