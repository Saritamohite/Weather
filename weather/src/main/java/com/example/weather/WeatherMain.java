package com.example.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherMain {

    @JsonProperty("temp")
    private double temp;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }
}

