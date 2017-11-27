package com.example.kumarm3.secondapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.ExifInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Makepayment extends AppCompatActivity {


    private EditText cardNumber;
    private EditText cvv;
    private EditText Expiry;
    private EditText cardHolder;
    private Button payButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.makepayment_activity);

        //cardNumber=(EditText)findViewById(R.id.cardNumbers);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        final String username_string = extras.getString("EXTRA_USERNAME");
        final String biller_name = extras.getString("BILLER_NAME");
        final String amount = extras.getString("AMOUNT");
        final String account_num = extras.getString("ACCOUNT_NUM");
        final String payment_date = extras.getString("PAYMENT_DATE");

        //final String username_string = extras.getString("EXTRA_USERNAME");


        Expiry=(EditText)findViewById(R.id.expDate);
        payButton=(Button)findViewById(R.id.PayButton);

        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(Makepayment.this)
                        .setMessage("Are you sure you want to make this payment?")
                        .setCancelable(false)
                        .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // AddBillers.this.finish();
                                //Toast.makeText(getApplicationContext(),"Biller was added",Toast.LENGTH_LONG);
                                String transactionId=createTransactionId();

                                Intent toBillersInfoIntent = new Intent(Makepayment.this, SummaryPage.class);
                                Bundle bundle=new Bundle();
                                bundle.putString("EXTRA_USERNAME",username_string);
                                bundle.putString("BILLER_NAME",biller_name);
                                bundle.putString("AMOUNT",amount);
                                bundle.putString("ACCOUNT_NUM",account_num);
                                bundle.putString("PAYMENT_DATE",payment_date);
                                bundle.putString("TransactionId",transactionId);
                                //bundle.putString("EXTRA_PASSWORD",password);
                                toBillersInfoIntent.putExtras(bundle);
                                startActivity(toBillersInfoIntent);
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .show();
            }
        });




    }

    private String createTransactionId() {

        String standardTag="UPMA";

        int transactionNumber=1000;

        String appender=String.format("%09d",transactionNumber);

        standardTag+=appender;

        return standardTag;
    }

}
