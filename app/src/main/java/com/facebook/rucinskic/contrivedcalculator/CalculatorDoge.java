package com.facebook.rucinskic.contrivedcalculator;

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

public class CalculatorDoge extends AppCompatActivity implements ICalculatorInteraction {

    private EditText txtNumber, txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_doge);

        Button btnAdd = (Button) findViewById(R.id.btnAddition);
        Button btnSub = (Button) findViewById(R.id.btnSubtract);
        Button btnMul = (Button) findViewById(R.id.btnMultiple);
        Button btnDiv = (Button) findViewById(R.id.btnDivide);

        txtNumber = (EditText) findViewById(R.id.txtNumber1);
        txtResult = (EditText) findViewById(R.id.txtResult);

        btnAdd.setOnClickListener(new OperationClick(Add).listenerOn(this));
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    public String getFirstNumber() { return valueOf(txtNumber); }

    @Override
    public String getSecondNumber() { return "2"; }

    @Override
    public void updateResult(String result) { txtResult.setText(result); }

    private String valueOf(EditText textbox) {

        String text = textbox.getText().toString();

        if (text.isEmpty()) {

            textbox.setText("0");
            return "0";

        }

        return text;
    }
}
