package com.facebook.rucinskic.contrivedcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import static com.facebook.rucinskic.contrivedcalculator.BinaryOperation.Add;
import static com.facebook.rucinskic.contrivedcalculator.BinaryOperation.Divide;
import static com.facebook.rucinskic.contrivedcalculator.BinaryOperation.Multiply;
import static com.facebook.rucinskic.contrivedcalculator.BinaryOperation.Subtract;

public class Calculator extends AppCompatActivity implements ICalculatorInteraction {

    // EditText declarations
    private EditText txtNumber1, txtNumber2, txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        // Extract the buttons from XML
        Button btnAdd = (Button) findViewById(R.id.btnAddition);
        Button btnSub = (Button) findViewById(R.id.btnSubtract);
        Button btnMul = (Button) findViewById(R.id.btnMultiple);
        Button btnDiv = (Button) findViewById(R.id.btnDivide);

        // Extract the EditText from the XML
        txtNumber1 = (EditText) findViewById(R.id.txtNumber1);
        txtNumber2 = (EditText) findViewById(R.id.txtNumber2);
        txtResult = (EditText) findViewById(R.id.txtResult);

        // Add ClickListeners to buttons
        btnAdd.setOnClickListener(new OperationClick(Add).listenerOn(this));    // One reference to OperationClick?
        btnSub.setOnClickListener(new OperationClick(Subtract).listenerOn(this));
        btnMul.setOnClickListener(new OperationClick(Multiply).listenerOn(this));
        btnDiv.setOnClickListener(new OperationClick(Divide).listenerOn(this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculator, menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {

            case R.id.ui_simple :
                startActivity(new Intent(this, Calculator.class));
                break;

            case R.id.ui_doge :
                startActivity(new Intent(this, CalculatorDoge.class));
                break;

        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    public String getFirstNumber() { return valueOf(this.txtNumber1); }

    @Override
    public String getSecondNumber() { return valueOf(this.txtNumber2); }

    @Override
    public void updateResult(Expression result) {

        String expression = String.format(
                "%s %s %s = %s",
                result.getFirstNumber(),
                result.getOperator(),
                result.getSecondNumber(),
                result.getTotal());

        this.txtResult.setText(expression);

    }

    private String valueOf(EditText textbox) {

        String text = textbox.getText().toString();

        if (text.isEmpty()) {

            textbox.setText("0");
            return "0";

        }

        return text;
    }
}
