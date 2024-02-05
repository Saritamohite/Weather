package com.example.weather;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${openweathermap.apiKey}")
    private String apiKey;

    @Value("${openweathermap.apiUrl}")
    private String apiUrl;

    public double getTemperature(String location) {
        String url = apiUrl + "?q=" + location + "&appid=" + apiKey + "&units=metric";
        try {
            OpenWeatherResponse response = new RestTemplate().getForObject(url, OpenWeatherResponse.class);
            if (response != null && response.getMain() != null) {
                return response.getMain().getTemp();
            }
        } catch (Exception e) {
            // Handle API request or parsing errors
            e.printStackTrace();
        }
        return Double.MIN_VALUE; // Return a placeholder value in case of errors
    }
}


