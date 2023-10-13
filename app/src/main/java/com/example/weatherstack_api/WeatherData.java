package com.example.weatherstack_api;

public class WeatherData {
    private Location location;
    private Current current;

    public Location getLocation() {
        return location;
    }

    public Current getCurrent() {
        return current;
    }

    public class Location {
        private String name;
        private String region;
        private String country;

        public String getName() {
            return name;
        }

        public String getRegion() {
            return region;
        }

        public String getCountry() {
            return country;
        }
    }

    public class Current {
        private double temperature;
        private String weather_descriptions;

        public double getTemperature() {
            return temperature;
        }

        public String getWeather_descriptions() {
            return weather_descriptions;
        }
    }
}
