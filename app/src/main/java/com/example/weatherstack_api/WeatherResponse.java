package com.example.weatherstack_api;
public class WeatherResponse {
    private Request request;
    private Location location;
    private Current current;

    public Request getRequest() {
        return request;
    }

    public Location getLocation() {
        return location;
    }

    public Current getCurrent() {
        return current;
    }

    public static class Request {
        private String type;
        private String query;
        private String language;
        private String unit;

        public String getType() {
            return type;
        }

        public String getQuery() {
            return query;
        }

        public String getLanguage() {
            return language;
        }

        public String getUnit() {
            return unit;
        }
    }

    public static class Location {
        private String name;
        private String country;
        private String region;
        private String lat;
        private String lon;
        private String timezone_id;
        private String localtime;
        private long localtime_epoch;
        private String utc_offset;

        public String getName() {
            return name;
        }

        public String getCountry() {
            return country;
        }

        public String getRegion() {
            return region;
        }

        public String getLat() {
            return lat;
        }

        public String getLon() {
            return lon;
        }

        public String getTimezone_id() {
            return timezone_id;
        }

        public String getLocaltime() {
            return localtime;
        }

        public long getLocaltime_epoch() {
            return localtime_epoch;
        }

        public String getUtc_offset() {
            return utc_offset;
        }
    }

    public static class Current {
        private String observation_time;
        private double temperature;
        private int weather_code;
        private String[] weather_icons;
        private String[] weather_descriptions;
        private int wind_speed;
        private int wind_degree;
        private String wind_dir;
        private int pressure;
        private int precip;
        private int humidity;
        private int cloudcover;
        private int feelslike;
        private int uv_index;
        private int visibility;
        private String is_day;

        public String getObservation_time() {
            return observation_time;
        }

        public double getTemperature() {
            return temperature;
        }

        public int getWeather_code() {
            return weather_code;
        }

        public String[] getWeather_icons() {
            return weather_icons;
        }

        public String[] getWeather_descriptions() {
            return weather_descriptions;
        }

        public int getWind_speed() {
            return wind_speed;
        }

        public int getWind_degree() {
            return wind_degree;
        }

        public String getWind_dir() {
            return wind_dir;
        }

        public int getPressure() {
            return pressure;
        }

        public int getPrecip() {
            return precip;
        }

        public int getHumidity() {
            return humidity;
        }

        public int getCloudcover() {
            return cloudcover;
        }

        public int getFeelslike() {
            return feelslike;
        }

        public int getUv_index() {
            return uv_index;
        }

        public int getVisibility() {
            return visibility;
        }

        public String getIs_day() {
            return is_day;
        }
    }
}
