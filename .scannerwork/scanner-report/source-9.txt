package com.example.weather_api;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Controller {
    public String weitherByCity(String city) {
        API api = new API();
        String weither;
        try {
            String configFilePath = "config.properties";
            FileInputStream propsInput = new FileInputStream(configFilePath);

            Properties prop = new Properties();
            prop.load(propsInput);
            String key = prop.getProperty("key");

            weither = api.weitherCity(city, key);
            if (weither == "") {
                weither = "Errore: reinserisci una città valida";
            }
        } catch (IOException e) {
            weither = "Errore: riprova";

        }
        return weither;
    }
}
