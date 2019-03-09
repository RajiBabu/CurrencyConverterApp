package com.example.android.assginment3.currencyconverterapp;


import android.content.Intent;
import android.content.BroadcastReceiver;
import android.content.Context;

public class AmountReceiver extends BroadcastReceiver {


    String convertedAmount;
    String amountStr;
    String convertTo;

    @Override
    public void onReceive(Context context, Intent intent) {

        convertedAmount = intent.getStringExtra("convertedAmount");
        convertTo = intent.getStringExtra("ConvertTo");
        amountStr = intent.getStringExtra("DollarAmount");

        Intent i = new Intent(context, MainActivity.class);
        i.putExtra("convertedAmount", convertedAmount);
        i.putExtra("DollarAmount", amountStr);
        i.putExtra("ConvertTo", convertTo);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}
