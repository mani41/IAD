package com.example.kumarm3.secondapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

public class SummaryPage extends AppCompatActivity {

    private TextView paymentSummary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sumarry_page);

        paymentSummary=(TextView)findViewById(R.id.paymentSummary);

        SpannableString content = new SpannableString("Payment Summary");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        paymentSummary.setText(content);
    }
}
