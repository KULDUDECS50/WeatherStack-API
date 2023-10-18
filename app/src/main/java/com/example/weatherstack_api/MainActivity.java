package com.example.weatherstack_api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private final String APIKEY = "7d8a814c0980cee604caf0d079c10a6f";
    public final String tag = "ku";
    private String url = "http://api.weatherstack.com/current?access_key=7d8a814c0980cee604caf0d079c10a6f&query=Palatine%Illinois%USA";
//            "http://api.weatherstack.com/current?access_key=" + APIKEY +"&query=Palatine%Illinois%USA"

    private TextView output;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = findViewById(R.id.output);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

            }
        });
    }
    public void fetchData(){
        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        parseJson(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                output.setText("That didn't work!");
            }
        });

        queue.add(stringRequest);
    }
    public void parseJson(String response){
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("location");
            String name, country, region;
            name = jsonObject.getString("name");
            country = jsonObject.getString("country");
            region = jsonObject.getString("region");
            output.append(("Name:" + name +"Region:" + region +"Country:" + country));

        }catch (JSONException e){
            e.printStackTrace();
        }
    }


}