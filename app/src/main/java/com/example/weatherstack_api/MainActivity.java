package com.example.weatherstack_api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
//

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
//import com.squareup.picasso.Picasso;

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
    ImageView image;
    WeatherResponse loc;
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
                        try {
                            Gson gson = new Gson();
                            WeatherResponse weatherResponse = gson.fromJson(response, WeatherResponse.class);


                            String cityName = weatherResponse.getLocation().getName();
                            String currentTime = weatherResponse.getCurrent().getObservation_time();
                            int temperature = weatherResponse.getCurrent().getTemperature();
                            String[] weatherIcons = weatherResponse.getCurrent().getWeather_icons();
                            String imgURL = weatherIcons[0];

                            // Create a formatted string with the weather data
                            String weatherInfo = "City: " + cityName + "\n" +
                                    "Time: " + currentTime + "\n" +
                                    "Temperature: " + temperature + "°C";

                            // Set the text of the TextView
                            output.setText(weatherInfo);
//                            Picasso.get()
//                                    .load(imgURL)
//                                    .into(image);

                        }catch(JsonSyntaxException e){
                            e.printStackTrace();
                        }

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
}