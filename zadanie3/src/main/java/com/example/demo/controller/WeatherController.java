package com.example.demo.controller;

import com.example.demo.OpenWeatherClient;
import com.example.demo.dto.ForecastResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
