package com.example.android.assginment3.currencyconverterapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.ComponentName;

public class MainActivity extends AppCompatActivity {

    EditText amount;
    Spinner convertTo;
    TextView convertedAmount;
    BroadcastReceiver br;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();

        if (null != intent) {
            String convertTo = intent.getStringExtra("ConvertTo");
            String amountStr = intent.getStringExtra("DollarAmount");
            String convertAmount = intent.getStringExtra("convertedAmount");

            if (null != convertAmount) {
                TextView textView = findViewById(R.id.convertedAmount);
                String s = "Dollar amount $" + amountStr + " converted to "+ convertAmount + " "+ convertTo;
                textView.setText(s);
            }
        }
    }


    public void onConvert(View v){
        amount = (EditText) findViewById(R.id.dollar_editText);
        convertTo = (Spinner) findViewById(R.id.spinner);

        Intent intent = new Intent("com.assignment.currencyConverter");
        intent.setAction("com.assignment.currencyConverter");
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        intent.setComponent(new ComponentName("com.example.android.assginment3.currencyconversionexchange", "com.example.android.assginment3.currencyconversionexchange.CurrencyConverterReceiver"));
        intent.putExtra("Dollar Amount", amount.getText().toString());
        intent.putExtra("Convert To", convertTo.getSelectedItem().toString());
        sendBroadcast(intent);
    }

    public void closeApp(View v){
        MainActivity.this.finish();
    }

}
