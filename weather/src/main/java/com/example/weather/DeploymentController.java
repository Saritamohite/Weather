package com.example.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deploy")
public class DeploymentController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/checkTemperature")
    public ResponseEntity<String> checkTemperatureForDeployment(@RequestParam String location) {
        double temperature = weatherService.getTemperature(location);
        if (temperature > 20) {
            return ResponseEntity.ok("Deployment allowed. Current temperature: " + temperature + "°C");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Deployment declined. Temperature too low: " + temperature + "°C");
        }
    }
}

