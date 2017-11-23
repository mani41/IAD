package com.example.kumarm3.secondapp;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by Mani Shankar on 11/21/2017.
 */

public class JsonParse extends Application{

    Context context;
    public JsonParse(Context context){
        this.context=context;
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
