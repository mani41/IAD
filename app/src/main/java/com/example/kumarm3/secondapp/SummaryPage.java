package com.example.kumarm3.secondapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SummaryPage extends AppCompatActivity {

    private TextView paymentSummary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sumarry_page);

        //paymentSummary=(TextView)findViewById(R.id.paymentSummary);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String transactionId = extras.getString("TransactionId");
        final String username_string = extras.getString("EXTRA_USERNAME");
        final String biller_name = extras.getString("BILLER_NAME");
        final String amount = extras.getString("AMOUNT");
        final String account_num = extras.getString("ACCOUNT_NUM");
        final String payment_date = extras.getString("PAYMENT_DATE");
        //String password_string = extras.getString("EXTRA_PASSWORD");

        String[] array = new String[] {"TransactionId:      :"+transactionId,"Customer name:    "+username_string,"Biller Name: "+biller_name,
                                        "Account#   "+account_num,"Amount Paid: "+amount,"Payment Date: "+payment_date};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array);

        ListView listView = (ListView) findViewById(R.id.printList);
        listView.setAdapter(adapter);

        //SpannableString content = new SpannableString("Payment Summary");
        //content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
       // paymentSummary.setText(username_string);
    }
}
