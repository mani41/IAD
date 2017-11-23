package com.example.kumarm3.secondapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BillersInfo extends AppCompatActivity {

    private Button addBillers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.billers_info);

        addBillers=(Button)findViewById(R.id.AddBillerB);

   //     TextView textView=findViewById(R.id.testId);

    //    JsonParse parser=new JsonParse();
    //    parser.loadPersonalInfo(textView);

        addBillers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toAddBillerIntent=new Intent(BillersInfo.this, AddBillers.class);
                startActivity(toAddBillerIntent);
            }
        });
    }
}
