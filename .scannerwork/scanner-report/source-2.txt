package com.example.weather_api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class API {
    public String weitherCity(String city, String key) throws IOException {
        try {
            //Da ora userò weatherapi.com
            /*String configFilePath = "config.properties";
            FileInputStream propsInput = new FileInputStream(configFilePath);

            Properties prop = new Properties();
            prop.load(propsInput);*/
            String city1;
            if (city.equals("Rome") || city.equals( "Roma"))
                city1 = "Vatican City";
            else
                city1 = city;

            OkHttpClient client = new OkHttpClient();

            Request req = new Request.Builder().url("https://api.openweathermap.org/data/2.5/weather?q="+ city1 + "&appid=" + key).build();

            Response resp = client.newCall(req).execute();
            assert resp.body() != null;
            String jsonData = resp.body().string();
            ObjectMapper mapper = new ObjectMapper();
            ObjectNode node = mapper.readValue(jsonData, ObjectNode.class);
            JsonNode weather = node.get("weather").get(0);
            return weather.get("main").toString();
        } catch (IOException e) {
            return "";
        }
    }
}
