package com.example.kumarm3.secondapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class BillersInfo extends AppCompatActivity {

private Button payButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.billers_info);

        Intent intent = getIntent();
        final Bundle extras = intent.getExtras();


        final Spinner mySpinner=(Spinner) findViewById(R.id.billersName);

        final EditText amount=(EditText)findViewById(R.id.Amount);

        final EditText confitrmAc=(EditText)findViewById(R.id.confirmAccount);

        final EditText date=(EditText)findViewById(R.id.date);



        payButton=(Button)findViewById(R.id.PayB);

        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent makePayment = new Intent(BillersInfo.this, Makepayment.class);
                Bundle bundle=new Bundle();

                String username_string = extras.getString("EXTRA_USERNAME");
                String spinner_text = mySpinner.getSelectedItem().toString();
                String amount_str=amount.getText().toString();
                final String confirmAc_str=confitrmAc.getText().toString();
                final String date_str=date.getText().toString();

                bundle.putString("EXTRA_USERNAME",username_string);
                bundle.putString("BILLER_NAME",spinner_text);
                bundle.putString("AMOUNT",amount_str);
                bundle.putString("ACCOUNT_NUM",confirmAc_str);
                bundle.putString("PAYMENT_DATE",date_str);
                //bundle.putString("EXTRA_PASSWORD",password);
                makePayment.putExtras(bundle);
                startActivity(makePayment);
            }
        });


    }
}
