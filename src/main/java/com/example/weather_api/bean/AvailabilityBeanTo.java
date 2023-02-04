package com.example.weather_api.bean;

import java.util.ArrayList;
import java.util.HashMap;

public class AvailabilityBeanTo {
    HashMap<String, ArrayList<String>> weather_by_hour;

    public HashMap<String, ArrayList<String>> getWeatherByHour() {
        return weather_by_hour;
    }

    public void setWeatherByHour(HashMap<String, ArrayList<String>> weather_by_hour) {
        this.weather_by_hour = weather_by_hour;
    }
}
