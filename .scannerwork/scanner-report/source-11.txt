package com.example.weather_api;

import com.example.weather_api.bean.AvailabilityBeanIn;
import com.example.weather_api.bean.AvailabilityBeanTo;
import com.example.weather_api.bean.WeatherApiBeanFrom;
import com.example.weather_api.bean.WeatherApiBeanTo;

public class Controller3 {
    public AvailabilityBeanTo weitherByCity(AvailabilityBeanIn bean_from) {
        //LocalDate date = LocalDate.now();
        //int year = date.getYear();
        //int day_year = date.getDayOfYear();
        WeatherApiBeanTo bean_to_weather = new WeatherApiBeanTo(bean_from.getCity());
        bean_to_weather.setGapDay(bean_from.getDate());

        WeatherBoundary weather_bound = new WeatherBoundary(bean_to_weather);
        WeatherApiBeanFrom weather_response = weather_bound.weitherCity();
        AvailabilityBeanTo weather_availability_to = new AvailabilityBeanTo();
        weather_availability_to.setWeatherByHour(weather_response.getWeather_by_hour());
        return weather_availability_to;
    }
}
