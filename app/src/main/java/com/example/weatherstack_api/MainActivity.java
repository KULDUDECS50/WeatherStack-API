package com.example.weatherstack_api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class MainActivity extends AppCompatActivity {
    private final String APIKEY = "7d8a814c0980cee604caf0d079c10a6f";
    private final String TAG = "Kuldeep";
    private final String API_REQUEST = "http://api.weatherstack.com/current?access_key=7d8a814c0980cee604caf0d079c10a6f&query=";
//            "http://api.weatherstack.com/current?access_key=7d8a814c0980cee604caf0d079c10a6f&query=";

    public String city;
    public String region;

    private TextView output;
    private Button button;
    private EditText cityET, regionET;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUp();

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                city = cityET.getText().toString();
                region = regionET.getText().toString();

                fetchData(city, region);
            }
        });
    }
    private void setUp(){
        output = findViewById(R.id.output);
        button = findViewById(R.id.button);
        cityET = findViewById(R.id.cityET);
        regionET = findViewById(R.id.regionET);
        image = findViewById(R.id.imageView);
    }

    public void fetchData(String city, String region){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = API_REQUEST + city+ "%" + region+"&units=f";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            Gson gson = new Gson();
                            WeatherResponse weatherResponse = gson.fromJson(response, WeatherResponse.class);


                            String cityName = weatherResponse.getLocation().getName();
                            String currentTime = weatherResponse.getCurrent().getObservation_time();
                            double temperature = weatherResponse.getCurrent().getTemperature();
                            //given in celcius
                            //now converted to farnheit
//                            temperature = (temperature * (9.0/5)) + 32;
                            String[] weatherIcons = weatherResponse.getCurrent().getWeather_icons();
                            String imgURL = weatherIcons[0];
                            Log.i(TAG, imgURL);


                            // Create a formatted string with the weather data
                            String weatherInfo = "City: " + cityName + "\n" +
                                    "Time: " + currentTime + "\n" +
                                    "Temperature: " + temperature + "°F";

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
                Log.i(TAG, "error response: " + error.getMessage());
                output.setText("That didn't work!");
            }

        });

        queue.add(stringRequest);
    }
}