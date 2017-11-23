package com.example.kumarm3.secondapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BillersInfo extends AppCompatActivity {

private Button payButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.billers_info);

        payButton=(Button)findViewById(R.id.PayB);

        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toBillersInfoIntent = new Intent(BillersInfo.this, Makepayment.class);
                startActivity(toBillersInfoIntent);
            }
        });


    }
}
