package com.example.weatherstack_api;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
//
import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private final String APIKEY = "7d8a814c0980cee604caf0d079c10a6f";
    public final String tag = "kuldeep";
    private String url = "http://api.weatherstack.com/current?access_key=7d8a814c0980cee604caf0d079c10a6f&query=Palatine%Illinois%USA/";
//            "http://api.weatherstack.com/current?access_key=" + APIKEY +"&query=Palatine%Illinois%USA"
//
    private String city, country, region, observationTime;
    private int temperature;
    //            Log.i("kuldeep", city + ", " + country + ", " + region + ", " + observationTime + ", " + temperature);
    //
    private TextView output;
    private Button button;
    private EditText cityET, stateET;
    Location loc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = findViewById(R.id.output);
        button = findViewById(R.id.button);
        cityET = findViewById(R.id.cityET);
        stateET = findViewById(R.id.stateET);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                fetchData();
            }
        });
    }
    public void fetchData(){
        String city = cityET.getText().toString();
        String state = stateET.getText().toString();

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://api.weatherstack.com/current?access_key=7d8a814c0980cee604caf0d079c10a6f&query=" + city+ "%" + state +"%"+ "USA";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        parseJson(response);
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("kuldeep", "error response: " + error.getMessage());
                output.setText("That didn't work!");
            }

        });

        queue.add(stringRequest);
    }
    public void parseJson(String response){

        Log.i("kuldeep", "response received!");
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        try {
            String jsonResponse  = gson.fromJson(response, String.class);
            JSONObject jsonObject = new JSONObject(jsonResponse);

            // Access specific parts of the data
            JSONObject request = jsonObject.getJSONObject("request");
            city = request.getString("query");

            JSONObject location = jsonObject.getJSONObject("location");
            country = location.getString("country");
            region = location.getString("region");

            JSONObject current = jsonObject.getJSONObject("current");
            observationTime = current.getString("observation_time");
            temperature = current.getInt("temperature");
            Log.i("kuldeep", city + ", " + country + ", " + region + ", " + observationTime + ", " + temperature);


        }


        catch (Exception e){
            e.printStackTrace();
        }
        Log.i("kuldeep", response);
        output.setText("Hello World");


    }


}