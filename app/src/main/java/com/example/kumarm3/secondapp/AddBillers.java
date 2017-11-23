package com.example.kumarm3.secondapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AddBillers extends AppCompatActivity {

    private Button AddNewBiller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_billers);

        AddNewBiller = (Button) findViewById(R.id.AddB);

        AddNewBiller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // get the biller name here and then ask for confirmation       -----> to do

                new AlertDialog.Builder(AddBillers.this)
                        .setMessage("Are you sure you want to add this?")
                        .setCancelable(false)
                        .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                               // AddBillers.this.finish();
                                //Toast.makeText(getApplicationContext(),"Biller was added",Toast.LENGTH_LONG);
                                Intent toBillersInfoIntent = new Intent(AddBillers.this, BillersInfo.class);
                                startActivity(toBillersInfoIntent);
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .show();


            }
        });
    }
}
