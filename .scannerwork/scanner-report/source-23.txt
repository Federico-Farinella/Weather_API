module com.example.weather_api {
    requires javafx.controls;
    requires javafx.fxml;
    requires httpcore;
    requires selenium.remote.driver;
    requires okhttp3;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;


    opens com.example.weather_api to javafx.fxml;
    exports com.example.weather_api;
    exports com.example.weather_api.bean;
}