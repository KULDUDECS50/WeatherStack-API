package com.example.weatherstack_api;

public class Current {
    private String time;
    private String temperature;
    private String weatherIconURL;

    public Current(String time, String temperature, String weatherIconURL) {
        this.time = time;
        this.temperature = temperature;
        this.weatherIconURL = weatherIconURL;
    }

    public String getTime() {
        return time;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getWeatherIconURL() {
        return weatherIconURL;
    }
}
