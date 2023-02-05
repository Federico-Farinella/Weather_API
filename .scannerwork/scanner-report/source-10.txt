package com.example.weather_api;

import com.example.weather_api.bean.WeatherApiBeanFrom;
import com.example.weather_api.bean.WeatherApiBeanTo;

import java.time.LocalDate;

public class Controller2 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        int year = date.getYear();
        int day_year = date.getDayOfYear();
        System.out.println(day_year);
        System.out.println(year);

        System.out.println(date);
        /*WeatherApiBeanTo bean_to = new WeatherApiBeanTo("Rome", key);
        bean_to.setGapDay(date);
        API2 api = new API2();*/
        WeatherApiBeanFrom weather;
        //try {
            /*String configFilePath = "config.properties";
            FileInputStream propsInput = new FileInputStream(configFilePath);

            Properties prop = new Properties();
            prop.load(propsInput);
            String key = prop.getProperty("key");
            System.out.println(key);*/

            WeatherApiBeanTo bean_to = new WeatherApiBeanTo("Rome");
            LocalDate date2 = LocalDate.of(2023,2,3);
            bean_to.setGapDay(date2);
            WeatherBoundary api = new WeatherBoundary(bean_to);
            //api.weitherCity(bean_to);

            weather = api.weitherCity();
            if (!weather.getResponse()) {
                System.out.println("Errore with Weather Service"); // Potrei ritornarlo alla GUI che avverte che non apparirà il meteo
                // Es. return some error or boolean??
            }

            //Qui stampo i risultati per vedere se funziona
            System.out.println("Ora stampo");
            int i;
            for (i = 15; i < 23; i++) {
                System.out.println(weather.getWeather_by_hour().get(Integer.toString(i)));
            }
            //System.out.println(weather.get("forecastday").get(0).get("hour").get(0).get("condition").get("text").toString());

            /*if (weither == "") {
                weither = "Errore: reinserisci una città valida";
            }*/
        /*} catch (IOException e) {
            //weither = "Errore: riprova"; // O come ritorno potrei impostare una stringa di errore in un altro responso del beanFrom
            // che mi dice che tipo di errore è stato rilevato e propagare un avviso tramite attributo del bean che torna dal
            // Controller al ContrellerGui dell utente :)
            //Comunque alla fine dovrò inserire weather in questo bean che provvedera alla conversione in HashMap che sarà accessibile
            //dal ControllerGui per fare apparire le  icone meteo :)

        }*/
    }
}
