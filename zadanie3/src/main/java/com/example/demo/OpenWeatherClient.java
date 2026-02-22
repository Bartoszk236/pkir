package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientResponseException;

@Component
@RequiredArgsConstructor
public class OpenWeatherClient {
    private final RestClient openWeatherRestClient;

    public ForecastResponse getForecastByCity(String city) {
        try {
            return openWeatherRestClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/data/2.5/forecast")
                            .queryParam("q", city)
                            .queryParam("units", "metric")
                            .queryParam("lang", "pl")
                            .queryParam("appid", "{appid}")
                            .build())
                    .retrieve()
                    .body(ForecastResponse.class);
        } catch (RestClientResponseException ex) {
            throw new RuntimeException("OpenWeather error for city: " + city, ex);
        }
    }
}
