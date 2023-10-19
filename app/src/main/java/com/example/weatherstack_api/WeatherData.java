package com.example.weatherstack_api;

public class WeatherData {
    private String name;
    private String country;
    private String region;

    public WeatherData(String name, String country, String region) {
        this.name = name;
        this.country = country;
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
