package com.example.weather_api.bean;

import java.time.LocalDate;

public class AvailabilityBeanIn {
    private String city;
    private LocalDate date;
    private String error_message;

    public AvailabilityBeanIn() {

    }

    private boolean checkGapDay(LocalDate date) {
        boolean ret = false;
        LocalDate actual_date = LocalDate.now();
        if (date.getDayOfYear() - actual_date.getDayOfYear() < 7) {
            ret = true;
        } else {
            this.error_message = "You can only make reservations within 7 days!";
        }
        return ret;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean setDate(LocalDate date) {
        boolean ret = false;
        if (this.checkGapDay(date)) {
            //Continua da qua... controllo sintattico data e città!!!
            this.date = date;
            ret = true;
        }

        return ret;
        //this.date = date;
    }
}
