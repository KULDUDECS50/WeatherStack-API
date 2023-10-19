package com.example.weatherstack_api;

public class Location {
    private String city;
    private String region;
    private String localtime;

    public Location(String city, String region, String localtime) {
        this.city = city;
        this.region = region;
        this.localtime = localtime;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLocaltime() {
        return localtime;
    }

    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }

    @Override
    public String toString() {
        return "Location{" +
                "city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", localtime='" + localtime + '\'' +
                '}';
    }
}