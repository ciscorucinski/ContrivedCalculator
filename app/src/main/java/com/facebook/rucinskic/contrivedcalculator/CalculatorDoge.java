package com.facebook.rucinskic.contrivedcalculator;

import android.os.Bundle;
import android.widget.EditText;

public class CalculatorDoge extends BaseCalculatorActivity {

    private EditText txtNumber, txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_doge);

        initializeOperationButtons();

        txtNumber = (EditText) findViewById(R.id.txtNumber1);
        txtResult = (EditText) findViewById(R.id.txtResult);

    }

    @Override
    public String getFirstNumber() { return valueOf(txtNumber); }

    @Override
    public String getSecondNumber() { return "2"; }

    @Override
    public void updateResult(Expression result) {

        String expression = String.format(
                "Wow! Such Calculation! %s",
                new Number(result.getTotal()).setDecimalPlace(2));

        this.txtResult.setText(expression);

    }

}
