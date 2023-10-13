package com.example.weatherstack_api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final String APIKEY = "7d8a814c0980cee604caf0d079c10a6f";
    private String url = "http://api.weatherstack.com/current?access_key=" + APIKEY;
    private TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = findViewById(R.id.output);

    }
}