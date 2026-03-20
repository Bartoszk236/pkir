package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class WeatherController {
    private final OpenWeatherClient openWeatherClient;
    private final List<String> cities = new ArrayList<>();

    @GetMapping("/weather/forecast")
    public ForecastResponse forecast(@RequestParam String city) {
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("Parameter 'city' is required");
        }
        return openWeatherClient.getForecastByCity(city.trim());
    }


    @PostMapping("/cities")
    public String addCity(@RequestBody CityRequest request) {
        if (request == null || request.name() == null || request.name().isBlank()) {
            throw new IllegalArgumentException("City name cannot be empty");
        }

        String cityName = request.name().trim();
        cities.add(cityName);

        return "City was added: " + cityName;
    }

    @GetMapping("/cities")
    public List<String> getCities() {
        return cities;
    }
}
