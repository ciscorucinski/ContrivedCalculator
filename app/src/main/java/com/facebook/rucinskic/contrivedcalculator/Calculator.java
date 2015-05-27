package com.facebook.rucinskic.contrivedcalculator;

import android.os.Bundle;
import android.widget.EditText;

public class Calculator extends BaseCalculatorActivity {

    // EditText declarations
    private EditText txtNumber1, txtNumber2, txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        initializeOperationButtons();

        // Extract the EditText from the XML
        txtNumber1 = (EditText) findViewById(R.id.txtNumber1);
        txtNumber2 = (EditText) findViewById(R.id.txtNumber2);
        txtResult = (EditText) findViewById(R.id.txtResult);

    }

    @Override
    public String getFirstNumber() { return valueOf(this.txtNumber1); }

    @Override
    public String getSecondNumber() { return valueOf(this.txtNumber2); }

    @Override
    public void updateResult(Expression result) {

        Number.setDefaultMaximumDecimalPlaces(2);

        String expression = String.format(
                "%s %s %s = %s",
                new Number(result.getFirstNumber()),
                result.getOperator(getOperationDisplayMode()),
                new Number(result.getSecondNumber()),
                new Number(result.getTotal()).setDecimalPlace(4));

        this.txtResult.setText(expression);

    }

}
