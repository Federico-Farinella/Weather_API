package com.example.weather_api.bean;

import java.time.LocalDate;

public class WeatherApiBeanTo {
    private final String city;
    //private final String key;
    private int gap_day;

    public WeatherApiBeanTo(String city) {
        this.city = city;
    }


    private boolean dateCheck(LocalDate date) {
        boolean ret = true;
        /*if (date.length() != 10) {
            ret = false;
        }*/
        // Da mettere nel controller o anzi no :)

        //LocalDate localdate = LocalDate.parse(date);
        int day = date.getDayOfMonth();
        //int day = Integer.parseInt(date.substring(0,1));
        int month = date.getMonthValue();
        //Integer month = Integer.parseInt(date.substring(3,4));
        int year = date.getYear();
        int request_day = date.getDayOfYear();
        LocalDate now = LocalDate.now();
        int today = now.getDayOfYear();
        int actual_year = now.getYear();

        if ((actual_year == year && request_day - today > 9)) { //|| (year == actual_year + 1 && 365 - today + request_day > 9)) {
            ret = false;
        }

        //int year = Integer.parseInt(date.substring(6,9));
        //Integer[] months_31 = {1, 3, 5, 7, 8, 10, 12};
        //Integer[] months_30 = {4, 6, 9, 11};
        /*if ((day > 30 && !Arrays.asList(months_30).contains(month)) || (day > 28 && month == 02)) {
            ret = false;
        }*/
        //else if (day >)
        //String year = date.substring(6,9);

        return ret;
    }

    public boolean setGapDay(LocalDate date){

        boolean ret = this.dateCheck(date);
        if (ret) {
            LocalDate now = LocalDate.now();
            int gap;
            int year, day, actual_year, actual_day;
            year = date.getYear();
            actual_year = now.getYear();
            day = date.getDayOfYear();
            actual_day = now.getDayOfYear();
            if (year == actual_year){
                this.gap_day = day - actual_day + 1;
                System.out.println("Gap day: " + gap_day);
            }
            else if (year == actual_year + 1) {
                this.gap_day = 365 - actual_day + day + 1;
            }
        }
        return ret;


    }

    public String getCity() {
        return city;
    }


    public int getGap_day() {
        return gap_day;
    }
}

