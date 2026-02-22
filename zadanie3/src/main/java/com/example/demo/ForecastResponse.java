package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ForecastResponse(
        City city,
        @JsonProperty("list") List<ForecastItem> items
) {
    public record City(String name, String country) {
    }

    public record ForecastItem(
            @JsonProperty("dt_txt") String dateTimeText,
            Main main,
            List<Weather> weather,
            Wind wind
    ) {
    }

    public record Main(double temp, @JsonProperty("feels_like") double feelsLike, int humidity) {
    }

    public record Weather(String main, String description, String icon) {
    }

    public record Wind(double speed) {
    }
}
