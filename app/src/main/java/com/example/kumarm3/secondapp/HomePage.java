package com.example.kumarm3.secondapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    private Button makePayment;
    private Button Enroll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_home_page);

        makePayment=(Button)findViewById(R.id.makePayment);

        makePayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toBillerInfoIntent = new Intent(HomePage.this, BillersInfo.class);
                startActivity(toBillerInfoIntent);
            }
        });




        Enroll=(Button)findViewById(R.id.Enroll);

        Enroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toBillerInfoIntent = new Intent(HomePage.this, AddBillers.class);
                startActivity(toBillerInfoIntent);
            }
        });


    }

}
