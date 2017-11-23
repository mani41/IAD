package com.example.kumarm3.secondapp;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends AppCompatActivity {

    private Button loginB;
    private EditText UserName;
    private EditText Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginB = (Button) findViewById(R.id.LoginB);
        UserName = (EditText) findViewById(R.id._username);
        Password = (EditText) findViewById(R.id._password);


        loginB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String user=UserName.getText().toString();
                String password=Password.getText().toString();

                TextView tv=(TextView)findViewById(R.id.jsonRawText);

                String json_str=readFromFile();

                PersonalInfo[] pi=ParseJson(json_str);

                boolean validateUser = Validate(pi,user,password);


                if (validateUser) {
                    Intent toHomePage = new Intent(MainActivity.this, HomePage.class);
                    startActivity(toHomePage);
                }else {
                    tv.setText("Username or Password is wrong!");
                    tv.setTextColor(Color.RED);
                }
            }
        });
    }

    private boolean Validate(PersonalInfo[] pi, String username, String pwd) {
        boolean validUser=false;
        for(int i=0; i<pi.length;i++){
            //String name=pi[i].getName();
                if((pi[i].getName()).equals(username) && pwd.equals("admin123"))
                    validUser= true;
        }
        return validUser;
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

    public PersonalInfo[] ParseJson(String jsonString){
        Gson gsonInstance = new Gson();
        PersonalInfo[] pi = gsonInstance.fromJson(jsonString,PersonalInfo[].class);
        return pi;
    }


}
