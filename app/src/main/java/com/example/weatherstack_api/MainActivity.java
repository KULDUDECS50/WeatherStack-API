package com.example.weatherstack_api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
//
import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private final String APIKEY = "7d8a814c0980cee604caf0d079c10a6f";
    public final String tag = "ku";
    private String url = "http://api.weatherstack.com/current?access_key=7d8a814c0980cee604caf0d079c10a6f&query=Palatine%Illinois%USA";
//            "http://api.weatherstack.com/current?access_key=" + APIKEY +"&query=Palatine%Illinois%USA"

    private TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = findViewById(R.id.output);
        // Call the fetchData method to fetch and parse JSON data
        fetchData(this, url, new VolleyCallback() {

            @Override
            public void onSuccess(String result) {
                Log.i(tag,"cSuccess");

                output.setText(result);
            }

            @Override
            public void onError(String errorMessage) {
                Log.i(tag,"cError");

                output.setText(errorMessage);
            }
        });
    }
    public interface VolleyCallback {
        void onSuccess(String result);
        void onError(String errorMessage);
    }
    public void fetchData(Context context, String url, final VolleyCallback callback) {
        RequestQueue queue = Volley.newRequestQueue(context);
        Log.i(tag,"c1");
        JsonObjectRequest jsonRequest = new JsonObjectRequest(

                Request.Method.GET, url, null,
                response -> {
                    // Parsing the JSON response
                    Log.i(tag,"c2");

                    try {
                        // Assuming you expect a JSON object with a "data" field
                        String data = response.optString("data");
                        Log.i(tag,"c3");

                        if (data != null) {
                            callback.onSuccess(data);
                        } else {
                            callback.onError("Data not found in the response");
                        }
                    } catch (Exception e) {
                        Log.i(tag,"c4");

                        e.printStackTrace();
                        callback.onError("JSON parsing error");
                    }
                },
                error -> {
                    Log.i(tag,"c5");

                    callback.onError("Network request failed");
                }
        );
        Log.i(tag,"c6");

        queue.add(jsonRequest);
    }

}