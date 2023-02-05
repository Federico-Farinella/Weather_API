package com.example.weather_api;

import com.example.weather_api.bean.WeatherApiBeanFrom;
import com.example.weather_api.bean.WeatherApiBeanTo;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class WeatherBoundary {

    /*public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request req = new Request.Builder().url("http://api.weatherapi.com/v1/forecast.json?key=111d329a4dd642298ae225849231801&q=Rome&days=3&aqi=no&alerts=no").build();

        Response resp = client.newCall(req).execute();
        assert resp.body() != null;
        String jsonData = resp.body().string();
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.readValue(jsonData, ObjectNode.class);
        JsonNode weather = node.get("forecast");//.get("forecastday");
        System.out.println("Ora stampo");
        System.out.println(weather);
        int i;
        for (i=15; i<22; i++) {
            System.out.println(weather.get("forecastday").get(0).get("hour").get(i).get("condition").get("text").toString());        }
        System.out.println(weather.get("forecastday").get(0).get("hour").get(0).get("condition").get("text").toString());
    }*/


    private final String city;
    //private String key;
    private final int gap_day;

    public WeatherBoundary(WeatherApiBeanTo bean_to) {
        this.city = bean_to.getCity();
        //this.key = bean_to.getKey();
        this.gap_day = bean_to.getGap_day();
    }
    public WeatherApiBeanFrom weitherCity() {
        WeatherApiBeanFrom bean = new WeatherApiBeanFrom();
        String configFilePath = "src/main/resources/config.properties";
        FileInputStream propsInput;
        System.out.println("Inizio metodo weitherCity API2");
        try {
            propsInput = new FileInputStream(configFilePath);


        } catch (FileNotFoundException e) {
            configFilePath = "config1.properties";
            try {
                propsInput = new FileInputStream((configFilePath));
            } catch (FileNotFoundException e2) {
                bean.setResponse(false);
                bean.setRespDescription("Error opening Api's configuration file");
                return bean;
            }
        }

        Properties prop = new Properties();
        try {
            prop.load(propsInput);
        } catch (IOException e) {
            e.printStackTrace();
            bean.setResponse(false);
            bean.setRespDescription("Error loading Api's calling properties");
            return bean;
        }
        String key = prop.getProperty("key");
        System.out.println(key);

        WeatherService service = new WeatherService();
        JsonNode weather = service.weatherService(city, key, gap_day);
        //WeatherApiBeanFrom bean = new WeatherApiBeanFrom();
        bean.setWeather(weather);
        System.out.println("Fine metodo weitherCity API2");
        //bean.setResponse(true);
        return bean;

        /*try {
            //Da ora userò weatherapi.com

            OkHttpClient client = new OkHttpClient();
            System.out.println("City:" + city + ", key: " + key + ", Gap day: " + gap_day);

            Request req = new Request.Builder().url("http://api.weatherapi.com/v1/forecast.json?key=" + key + "&q=" + city + "&days=" + gap_day + "&aqi=no&alerts=no").build();

            Response resp = client.newCall(req).execute();
            assert resp.body() != null;
            String jsonData = resp.body().string();
            ObjectMapper mapper = new ObjectMapper();
            ObjectNode node = mapper.readValue(jsonData, ObjectNode.class);
            System.out.println("Ora stampo weather da API2");
            JsonNode weather = node.get("forecast").get("forecastday").get(gap_day-1);
            System.out.println("Ora stampo weather da API2");
            System.out.println(weather);
            WeatherApiBeanFrom bean = new WeatherApiBeanFrom();
            bean.setWeather(weather);
            return bean;
            //JsonNode weather_day = weather.get(gap_day);
            //return weather.get("date").toString();
        } catch (IOException e) {
            WeatherApiBeanFrom bean = new WeatherApiBeanFrom();
            bean.setWeather(null);
            return bean;
        }*/
    }
}
