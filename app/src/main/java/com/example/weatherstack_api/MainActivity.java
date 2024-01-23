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
//import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.text.ParseException;

public class MainActivity extends AppCompatActivity {
    // Constants: API Key and Endpoint URL
/*    private final String APIKEY = "7d8a814c0980cee604caf0d079c10a6f";
      private final String TAG = "Kuldeep";
   private final String API_REQUEST = "http://api.weatherstack.com/current?access_key=7d8a814c0980cee604caf0d079c10a6f&query=";
*/
    // Variables to store user input
    public String city;
    public String region;

    // UI components
    private TextView output;
    private Button button;
    private EditText cityET, regionET;
    ImageView imageView;

    // Called when the activity is first created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUp();

        // Setting up a click listener for the button
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // Get city and region from user input
                city = cityET.getText().toString();
                region = regionET.getText().toString();
                if(city != null) {
                    fetchData(city, region); // Fetch the weather data
                }
            }
        });
    }

    // Initialize UI components
    private void setUp(){
        output = findViewById(R.id.output);
        button = findViewById(R.id.button);
        cityET = findViewById(R.id.cityET);
        regionET = findViewById(R.id.regionET);
        imageView = findViewById(R.id.imageView);
    }

    // Method to fetch weather data from API
    /**
     * Send an API request with user given city and region
     * Parses the JSON response
     * Outputs the given data in a simplified manner in the TextView
     *
     * @param city city title
     * @param region region title
     * */
    public void fetchData(String city, String region){
        // Setting up Volley request queue
//        RequestQueue queue = Volley.newRequestQueue(this);
//        String url = API_REQUEST + city+ "%" + region+"&units=f"; // Constructing the complete API URL

        // Creating a string request to fetch data

        // commenting out to manage api usage

        /* StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    // Callback method called on successful API response
                    @Override
                        public void onResponse(String response) {
                            try {
                                // Using Gson to convert API response to a Java object
                                Gson gson = new Gson();
                                WeatherResponse weatherResponse = gson.fromJson(response, WeatherResponse.class);

                                // Extracting data from the response
                                String cityName = weatherResponse.getLocation().getName();
                            String currentTime = weatherResponse.getLocation().getLocaltime();
                            double temperature = weatherResponse.getCurrent().getTemperature();
                            String[] weatherIcons = weatherResponse.getCurrent().getWeather_icons();
                            String imgURL = weatherIcons[0];
                            Log.i(TAG, imgURL);

                            // Formatting the extracted data for display
                            String weatherInfo = "City: " + cityName + "\n" +
                                    "Time: " + currentTime + "\n" +
                                    "Temperature: " + temperature + "°F";
        
                            // Displaying the formatted data on UI
                            output.setText(weatherInfo);
                            //Glide.with(MainActivity.this).load(imgURL).into(imageView);

                            // Uncomment the below line to set image using Picasso
                            // Picasso.get().load(imgURL).into(image);

                        }catch(JsonSyntaxException e){
                            e.printStackTrace(); // Handle JSON parsing errors
                        } catch (ParseException e) {
                            throw new RuntimeException(e); // Handle date parsing errors
                        }
                    }
                },
                new Response.ErrorListener() {
                    // Callback method called on API request failure
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i(TAG, "error response: " + error.getMessage());
                        output.setText("That didn't work!");
                    }
                });

        // Adding the request to the queue to be executed
        queue.add(stringRequest);
*/
    }
}
