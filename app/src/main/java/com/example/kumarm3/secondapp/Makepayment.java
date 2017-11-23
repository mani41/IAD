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
                                Intent toBillersInfoIntent = new Intent(Makepayment.this, SummaryPage.class);
                                startActivity(toBillersInfoIntent);
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .show();
            }
        });




    }

}
