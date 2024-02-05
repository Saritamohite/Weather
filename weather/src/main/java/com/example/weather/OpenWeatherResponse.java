package com.example.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenWeatherResponse {

    @JsonProperty("main")
    private WeatherMain main;

    public WeatherMain getMain() {
        return main;
    }

    public void setMain(WeatherMain main) {
        this.main = main;
    }
}

