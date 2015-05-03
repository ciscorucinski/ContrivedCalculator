package com.facebook.rucinskic.contrivedcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Calculator extends AppCompatActivity {

    // Button and EditText declaration
    Button btnAdd, btnSub, btnMul, btnDiv;
    EditText txtNumber1, txtNumber2, txtResult;

    // OnClickListener declaration
    View.OnClickListener addListener, subListener, mulListener, divListener;

    // Variables for math operations
    double total, num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        // Extract the buttons from XML
        btnAdd = (Button) findViewById(R.id.btnAddition);
        btnSub = (Button) findViewById(R.id.btnSubtract);
        btnMul = (Button) findViewById(R.id.btnMultiple);
        btnDiv = (Button) findViewById(R.id.btnDivide);

        // Extract the EditText from the XML
        txtNumber1 = (EditText) findViewById(R.id.txtNumber1);
        txtNumber2 = (EditText) findViewById(R.id.txtNumber2);
        txtResult = (EditText) findViewById(R.id.txtResult);

        // Add Listeners
        addListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                num1 = Double.parseDouble(txtNumber1.getText().toString());
                num2 = Double.parseDouble(txtNumber2.getText().toString());

                total = new Operation(new Add()).execute(num1, num2);

                txtResult.setText(Double.toString(total));

            }
        };

        // Subtract Listener
        subListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                num1 = Double.parseDouble(txtNumber1.getText().toString());
                num2 = Double.parseDouble(txtNumber2.getText().toString());

                total = new Operation(new Subtract()).execute(num1, num2);

                txtResult.setText(Double.toString(total));

            }
        };

        // Multiply Listener
        mulListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                num1 = Double.parseDouble(txtNumber1.getText().toString());
                num2 = Double.parseDouble(txtNumber2.getText().toString());

                total = new Operation(new Multiply()).execute(num1, num2);

                txtResult.setText(Double.toString(total));

            }
        };

        // Divide Listener
        divListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                num1 = Double.parseDouble(txtNumber1.getText().toString());
                num2 = Double.parseDouble(txtNumber2.getText().toString());

                total = num1 / num2; // new Operation(new Divide()).execute(num1, num2);

                txtResult.setText(Double.toString(total));

            }
        };

        // Add ClickListeners to buttons
        btnAdd.setOnClickListener(addListener);
        btnSub.setOnClickListener(subListener);
        btnMul.setOnClickListener(mulListener);
        btnDiv.setOnClickListener(divListener);

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
}
