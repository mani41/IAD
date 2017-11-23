package com.example.kumarm3.secondapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

public class DummyBillersInfo extends AppCompatActivity {

    private static final String TAG = DummyBillersInfo.class.getName();
    private Button AddBillerDummy;
    private TextView testText;
    //private Gson gsonInstance;
    //private PersonalInfo[] pi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dummy_billers_info);


        AddBillerDummy = (Button) findViewById(R.id.AddBillerB);
        testText = (TextView) findViewById(R.id.testId);

        AddBillerDummy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //JsonParse parse=new JsonParse();
                //parse.loadPersonalInfo(testText);

                String json_string;
                json_string = readFromFile();

                TextView tv = (TextView) findViewById(R.id.testId);

                //tv.setText(json_string);

                Log.i(TAG,json_string);

                //Parsing Json

                PersonalInfo[] pi=ParseJson(json_string);

                //pi = gsonInstance.fromJson(json_string,pi[].getClass());
                //pi is an array and iterate through it for whatever
                //Log.i(TAG,pi.toString());
                tv.setText(pi[0].getEmail().toString());
            }
        });

    }

    public static PersonalInfo[] ParseJson(String jsonString){
        Gson gsonInstance = new Gson();
        PersonalInfo[] pi = gsonInstance.fromJson(jsonString,PersonalInfo[].class);
        return pi;
    }

    public String readFromFile() {
        // String FileName = "all_user";     //reading this json file

        StringBuffer sbJsonString = new StringBuffer();
        InputStream is = getResources().openRawResource(R.raw.all_user);

        int character;

        try {
            while ((character = is.read()) != -1) {
                sbJsonString.append((char) character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sbJsonString.toString();
    }
}
