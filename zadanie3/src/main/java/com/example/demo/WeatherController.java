package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeatherController {
    private final OpenWeatherClient openWeatherClient;

    @GetMapping("/weather/forecast")
    public ForecastResponse forecast(@RequestParam String city) {
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("Parameter 'city' is required");
        }
        return openWeatherClient.getForecastByCity(city.trim());
    }
}
