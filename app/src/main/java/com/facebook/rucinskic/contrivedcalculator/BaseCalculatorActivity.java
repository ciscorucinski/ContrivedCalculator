package com.facebook.rucinskic.contrivedcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import static com.facebook.rucinskic.contrivedcalculator.BinaryOperation.Add;
import static com.facebook.rucinskic.contrivedcalculator.BinaryOperation.Divide;
import static com.facebook.rucinskic.contrivedcalculator.BinaryOperation.Multiply;
import static com.facebook.rucinskic.contrivedcalculator.BinaryOperation.Subtract;

public abstract class BaseCalculatorActivity extends AppCompatActivity implements ICalculatorInteraction {

    private BinaryOperation.Display display = BinaryOperation.Display.SIGN;

    void initializeOperationButtons() {

        // Extract the buttons from XML
        Button btnAdd = (Button) findViewById(R.id.btnAddition);
        Button btnSub = (Button) findViewById(R.id.btnSubtract);
        Button btnMul = (Button) findViewById(R.id.btnMultiple);
        Button btnDiv = (Button) findViewById(R.id.btnDivide);

        // Add ClickListeners to buttons
        btnAdd.setOnClickListener(new OperationClick(Add).listenerOn(this));
        btnSub.setOnClickListener(new OperationClick(Subtract).listenerOn(this));
        btnMul.setOnClickListener(new OperationClick(Multiply).listenerOn(this));
        btnDiv.setOnClickListener(new OperationClick(Divide).listenerOn(this));
    }

    String valueOf(EditText textbox) {

        String text = textbox.getText().toString();

        if (text.isEmpty()) {

            textbox.setText("0");
            return "0";

        }

        return text;
    }

    public BinaryOperation.Display getOperationDisplayMode() { return this.display; }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculator, menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.ui_simple : return goToActivity(Calculator.class);
            case R.id.ui_doge   : return goToActivity(CalculatorDoge.class);
            case R.id.ui_static : return goToActivity(CalculatorStatic.class);

            case R.id.mode_sign : return selectMode(item, BinaryOperation.Display.SIGN);
            case R.id.mode_verb : return selectMode(item, BinaryOperation.Display.VERB);
            case R.id.mode_noun : return selectMode(item, BinaryOperation.Display.NOUN);

            default : return super.onOptionsItemSelected(item);
        }
    }

    private boolean goToActivity(Class<?> activity) {

        startActivity(new Intent(this, activity));
        return true;
    }

    private boolean selectMode(MenuItem item, BinaryOperation.Display display) {

        item.setChecked(true);
        this.display = display;
        return true;

    }

}
